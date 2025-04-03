<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 로그 아웃 시 세션 만료되게 처리 -->
<%
	/* 세션 초기화 함수 */
	session.invalidate();

	/* out 내장 객체 사용 */
	out.println("<script> alert('로그아웃 성공! Login page로 이동합니다.');location.href='login_form.jsp?message=Logout Success'</script>");


%>