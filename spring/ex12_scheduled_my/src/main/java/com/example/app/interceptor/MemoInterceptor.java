package com.example.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MemoInterceptor implements HandlerInterceptor{

	// memoController로 이동하기 전 처리
	// 컨트롤러 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MemoInterceptor's preHandle");
		return true;
	}

	// memoController의 작업이 끝난 이후 처리
	// 컨트롤러 진입 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MemoInterceptor's postHandle");
	}
	
	// view page로 랜더링(표시) 된 이후 처리
	// 페이지가 띄워진 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MemoInterceptor's afterCompletion");
	}
	
}
