package com.example.demo.config.auth.logoutHandler;

import com.example.demo.config.auth.PrincipalDetails;
import com.example.demo.config.auth.jwt.JwtProperties;
import com.example.demo.domain.repository.JwtTokenRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;

@Component
@Slf4j
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	String KAKAO_CLIENT_ID;
	@Value("${spring.security.oauth2.client.kakao.logout.redirect.uri}")
	String KAKAO_LOGOUT_REDIRECT_URI;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("CustomLogoutSuccessHandler onLogoutSuccess invoke.."+authentication);
		
		// ------------------------------------------------------------------
		// TOKEN DB에서 삭제
		String token = Arrays.stream(request.getCookies())
				.filter(cookie -> cookie.getName().equals(JwtProperties.ACCESS_TOKEN_COOKIE_NAME)).findFirst()
				.map(cookie -> cookie.getValue())
				.orElse(null);
		jwtTokenRepository.deleteByAccessToken(token);
		
		// ------------------------------------------------------------------
		// 발급받은 ACCESS-TOKEN 쿠키 제거
		// 토큰 : 클라이언트 브라우저에서 쿠키 형태로 쥐고 있음 -> request에서 꺼내오기
		// 취소 걍 있는 쿠키 유지시간 0으로 만들면 됨
		// ------------------------------------------------------------------
		Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
		// principalDetails 여기에 userDto가 있음 -> provider꺼낼 수 있음
		String provider = principalDetails.getUserDto().getProvider();
		if(provider!=null&&provider.startsWith("kakao")){
			// return "redirect:https://kauth.kakao.com/oauth/logout?client_id="+CLIENT_ID+"&logout_redirect_uri="+LOGOUT_REDIRECT_URI;
			response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id="+KAKAO_CLIENT_ID+"&logout_redirect_uri="+KAKAO_LOGOUT_REDIRECT_URI);
			return;
		}else if(provider!=null&&provider.startsWith("naver")){
			// return "redirect:https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/";
			response.sendRedirect("https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/");
			return;
		}else if(provider!=null&&provider.startsWith("google")){
			response.sendRedirect("https://accounts.google.com/Logout");
			return;
		}

		response.sendRedirect("/");
	}

}
