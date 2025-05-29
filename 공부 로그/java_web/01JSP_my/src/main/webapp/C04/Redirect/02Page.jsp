<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- URLEncoder 위치 -->
<%@ page import="java.net.*" %>

<%
	/* request로 파라미터 받아오기 */
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	/* 콘솔 출력 */
	System.out.println("---------02Page---------");
	System.out.println("username : "+username);
	System.out.println("password : "+password);
	System.out.println("------------------------");
	
	request.setAttribute("02Page", "02PageValue");
	
	/* Redirection */
	/* response.sendRedirect("이동 URI"); */
	/* response.sendRedirect("./03Page.jsp"); */
	
	/* 영어, 숫자 문제 없음 / 한글 따로 인코딩 필요 */
	/* response.sendRedirect("./03Page.jsp?hobby=run"); */
	response.sendRedirect("./03Page.jsp?hobby="+URLEncoder.encode("등산","UTF-8"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>02Page</h1>
	UserName : <%=username %> <br />
	Password : <%=password %> <br />
</body>
</html>