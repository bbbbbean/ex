<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* path 설정에 따라 범위가 달라짐 : 쿠키가 던져지는 시점 */
	/* 개발자 도구 application -> cookie에서 확인가능 */
	Cookie cookie1 = new Cookie("c1","v1");
	cookie1.setMaxAge(60*10);	// 10분
	cookie1.setPath("/");	// 현재 도메인 내 모든 URI에 전달 (모든 페이지로 해당 쿠키 전달)
							// 01 폴더의 index에서도 확인 가능
	
	Cookie cookie2 = new Cookie("c2","v2");
	cookie2.setMaxAge(60*10);
	cookie2.setPath("./");	// 현재 패키지 내에 있는 페이지로만 전달, 여기서는 02폴더 내
	
	Cookie cookie3 = new Cookie("c3","v3");
	cookie3.setMaxAge(60*10);
	cookie3.setPath("/01JSP_my/C07/02/getCookie.jsp");	// 지정된 페이지로만 전달
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	response.addCookie(cookie3);

%>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./getCookie.jsp">쿠키 확인하기</a>
</body>
</html>