<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*,Utils.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0; padding:0;}
	a{color:#fff; text-decoration:none;margin-left:30px;}
	li,ul{list-style:none;}
	header,footer{height:100px;text-align:center;line-height:100px;}
	h2{color:#fff;}
	nav{height:80px;}
	nav>ul{display:flex;}
	nav>ul>li{padding-top:30px;}
	main{height:calc(100vh - 280px);background-color:lightgray;}
</style>
</head>
<%
	List<StudentDto> list = DBUtils.getInstance().selectAllStudent();
%>

<body>
	<%@include file="/layout/header.jsp" %>
	<%@include file="/layout/nav.jsp" %>
	<main>
		<h3>학사관리 프로그램</h3>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학년</th>
				<th>반</th>
				<th>번호</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</main>
	<%@include file="/layout/footer.jsp" %>
</body>
</html>