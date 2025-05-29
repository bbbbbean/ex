<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 세션 정보 초기화시 로그인 페이지로 날리기 -->    
<%
	if(session.getAttribute("isAuth")==null){
		// request.getRequestDispatcher("./login_form.jsp").forward(request,response);
		response.sendRedirect("./login_form.jsp?message=Session Espired");
	}
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="./logout.jsp">로그아웃</a>
	<hr />
	<h1>Main Page</h1>
	
	<!-- 역할 정보 확인 -->
	IsAuth : <%=session.getAttribute("isAuth") %> <br />
	Role : <%=session.getAttribute("role") %> <br />
	
	<!-- EL표현식 -->
	IsAuth : ${isAuth} <br />
	Role : ${role} <br />
	
</body>
</html>