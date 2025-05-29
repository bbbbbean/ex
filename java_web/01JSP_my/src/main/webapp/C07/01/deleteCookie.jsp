<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String cookieName = request.getParameter("cookieName");
	if(cookieName!=null){
		// path 경로가 맞지 않아 안먹혔던거, 맞춰주기 -> (/: 모든 영역) 이건 확인 후 쓰기
		Cookie cookie = new Cookie(cookieName,null); // 빈 Value의 쿠키 생성
		cookie.setMaxAge(0);	// 쿠키 유지 시간 0초 (만료 설정) **
		//cookie.setPath("/");	// 쿠키 적용 URI 설정 (/: 모든 영역)
		response.addCookie(cookie);	// 만료 처리 전달
	}
	
	out.println("<script> alert('쿠키 삭제 완료'); location.href='getCookie.jsp'</script>");
	// 만료 쿠키 전달 후 다음 이동 위치 전달(ReDirect)
	/* response.sendRedirect("./getCookie.jsp"); */
%>