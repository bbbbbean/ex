<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--
	Cookie
	문자열 데이터만 저장 가능
	4kbyte이하의 공간을 차지
	여러개의 쿠키 설정 가능 (최대 300개)
	도메인당 20개까지 저장 가능
	저장 한도를 초과하면 최근에 사용되지 않는 쿠키부터 자동 삭제
-->
<%
	Cookie cookie1 = new Cookie("myCookie1","myCookie1Value");
	cookie1.setMaxAge(30);	// 쿠키 유지 시간 (-1: 기본값 : 파일 생성 X, 브라우저가 종료될 때까지 쿠키 저장)
							// 30초 설정 - 브라우저에서 유효 <-> 세션 : 서버에서 유효

	Cookie cookie2 = new Cookie("myCookie2","myCookie2Value");
	cookie1.setMaxAge(60*5);// 5분 설정
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
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