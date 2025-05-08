<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*,com.example.app.domain.Dto.*, com.example.app.domain.Dao.*"  %>
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
		<th></th>		
	</tr>
	<% List<UserDto> list = UserDaoImpl. %>
	<tr>
		<td><%=%></td>
		<td><%=%></td>
		<td><%=%></td>
		<td><button>수정</button></td>
		<td><button>삭제</button></td>
	</tr>
</table>

</body>
</html>
