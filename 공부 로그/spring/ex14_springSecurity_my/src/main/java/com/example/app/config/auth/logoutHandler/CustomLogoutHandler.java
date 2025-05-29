package com.example.app.config.auth.logoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLogoutHandler implements LogoutHandler {

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// 로그아웃 핸들러는 성공, 실패시가 아니라 로그아웃 기능을 직접 다루는 핸들러
		// 소셜 로그아웃 처리 등
		// 지금은 단순히 세션 무효화 처리
		log.info("CustomLogoutHandler's logout invoke");
		HttpSession session = request.getSession();
		if(session!=null) {
			// 세션 초기화
			session.invalidate();
		}
	}

}
