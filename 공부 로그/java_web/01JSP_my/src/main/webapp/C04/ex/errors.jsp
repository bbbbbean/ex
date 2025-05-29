<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- errorpage : exception 내장객체로 예외 탐지 가능 -->
	<h1>Error Page</h1>
	<hr />
	<%=exception.getMessage() %>
</body>
</html>