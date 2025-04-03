<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<hr />
	<form action="" method="post">
		<label>아이디</label>
		<input type="text" name="userId"/>
		<span>${userid_msg}</span>
		<br />
		<label>패스워드</label>
		<input type="text" name="password"/>
		<span>${password_msg}</span>
		<br />
		<button>로그인</button>	
	</form>
</body>
</html>