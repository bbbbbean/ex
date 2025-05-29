package com.example.demo.config.auth.logoutHandler;

import com.example.demo.config.auth.PrincipalDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	String KAKAO_CLIENT_ID;
	@Value("${spring.security.oauth2.client.kakao.logout.redirect.uri}")
	String KAKAO_LOGOUT_REDIRECT_URI;


	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("CustomLogoutSuccessHandler onLogoutSuccess invoke..");

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
