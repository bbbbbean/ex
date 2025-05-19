package com.example.demo.config.auth.loginHandler;

import com.example.demo.config.auth.jwt.JwtProperties;
import com.example.demo.config.auth.jwt.JwtTokenProvider;
import com.example.demo.config.auth.jwt.TokenInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	// provider == component -> 연결 가능
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

		log.info("CustomLoginSuccessHandler's onAuthenticationSuccess invoke..");
		
		// TOKEN 쿠키로 전달
		// 로그인 성공 시 토큰을 만들어 쿠키 형태로 정보 던짐?
		// 로그인 했으면 정보가 있겠지.. 거기서 꺼내오기
		//String username = authentication.getName();
		TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
		// 토큰 쿠키화
		Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,tokenInfo.getAccessToken()); // (key, value)
		// 유효기간
		cookie.setMaxAge(JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);
		// 쿠키 적용 위치 - 모든 경로
		cookie.setPath("/");
		response.addCookie(cookie);

		response.sendRedirect(request.getContextPath()+"/");
	}
}
