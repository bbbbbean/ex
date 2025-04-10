<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JOIN PAGE</h1>
	<form action="${pageContext.request.contextPath}/join.do" method="post">
		<label for="">id</label>
		<input name="username" /><br/>
		<label for="">password</label>
		<input name="password" /><br/>
		<label for="">주소</label>
		<input name="addr" /><br/>
		<button>회원가입</button>
		<div>${msg}</div>
	</form>

</body>
</html>