<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	span{font-size:.8rem; color:red;}

</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr />
	<form action="${pageContext.request.contextPath}/C06/03/join.jsp" method="post">
		<label>아이디</label>
		<input type="text" name="userId"/>
		<span>${userid_msg}</span>
		<br />
		<label>패스워드</label>
		<input type="text" name="password"/>
		<span>${password_msg}</span>
		<br />
		<button>회원 가입</button>	
	</form>
</body>
</html>