<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* request로 파라미터 받아오기 */
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	/* 02 내용 꺼내기 */
	String Page02Value = (String)request.getAttribute("02Page");
	
	/* 콘솔 출력 */
	/* request 내용은 01의 것 유지 == 03에서 확인가능 */
	/* 2를 거치면서 02 내용 전부 작동 -> 02 내용과 03내용 전부 콘솔 확인 가능 */
	System.out.println("---------03Page---------");
	System.out.println("username : "+username);
	System.out.println("password : "+password);
	System.out.println("Page02Value : "+Page02Value);
	System.out.println("------------------------");
	
	/* Forwarding */
	request.setAttribute("03Page","03Page's Value");
	request.getRequestDispatcher("./04Result.jsp").forward(request,response);
	
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