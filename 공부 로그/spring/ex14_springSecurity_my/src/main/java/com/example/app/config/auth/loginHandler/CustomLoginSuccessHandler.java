package com.example.app.config.auth.loginHandler;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// 로그인 성공 시 핸들러
		// 핸들러를 등록하지 않으면 알아서 페이지 이동 등 처리
		// 핸들러를 등록하면 이동 위치 등을 커스텀 해줘야함
		log.info("CustomLoginSuccessHandler's onAuthenticationSuccess invoke");
		response.sendRedirect(request.getContextPath()+"/");
	}

}
