<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* request 내장 객체 : 요청 정보 값 저장(HTTP Request Protocol의 구조형태) */
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String bgColor = request.getParameter("bgcolor");
	System.out.printf("%s, %s, %s \n",username,password,bgColor);
	/* 백엔드에서 처리 후 결과만 표현 됨 -> 개발도구 열어도 안보임 */
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:<%=bgColor.equals("")?"#f5f5f5":bgColor %>">

	username : <%=username %>
	<hr />
	password : <%=password %>
	<hr />
	bgColor : <%=bgColor %>
	<hr />
</body>
</html>