<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	
	/* Forwarding */
	/* 내부적으로 다른 페이지로 넘김 */
	/* URL은 02에 머물러있지만 03페이지 반환 */
	/* request.getRequestDispatcher("이동 URI").forward(request,response); */
	request.getRequestDispatcher("./03Page.jsp").forward(request,response);
	
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