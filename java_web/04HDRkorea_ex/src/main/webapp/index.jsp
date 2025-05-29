<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	<%@include file="./layout/header.jsp" %>
	<%@include file="./layout/nav.jsp" %>
	<main>
		<h3>학사관리 프로그램</h3>
	</main>
	<%@include file="./layout/footer.jsp" %>
</body>
</html>