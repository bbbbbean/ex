<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* request로 파라미터 받아오기 */
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	/* 02 내용 꺼내기 */
	String Page02Value = (String)request.getAttribute("02Page");
	
	/* 콘솔 출력 */
	/* request가 새로운 요청에 의해 초기화됨 */

	System.out.println("---------03Page---------");
	System.out.println("username : "+username);
	System.out.println("password : "+password);
	System.out.println("Page02Value : "+Page02Value);
	System.out.println("------------------------");
	
	String hobby = request.getParameter("hobby");
	System.out.println("hobby : "+hobby);
	
	/* Redirect */
	response.sendRedirect("./04Result.jsp");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>03Page</h1>
</body>
</html>