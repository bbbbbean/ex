<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*,com.example.app.domain.Dto.*"  %>
<html>
<head>
	<title>list</title>
</head>
<body>
<h1>
	회원 목록  
</h1>
<table>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>닉네임</th>
		<th></th>		
	</tr>
	<tr>
		<td><input placeholder="<%=%>" readonly></td>
		<td><input type="text" placeholder="<%=%>" ></td>
		<td><input type="text" placeholder="<%=%>" ></td>
		<td><button>수정</button></td>
	</tr>
</table>

</body>
</html>
