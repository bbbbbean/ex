<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	:root{}
	*{box-sizing:border-box;}
	body{margin:0;padding:0;}
	ul{list-style:none;margin:0;padding:0;}
	a{text-decoration:none; color:black;}

	.wrapper{}
	.wrapper>header{height:100px;}
	.wrapper>nav{height:40px;}
	.wrapper>main{height:calc(100vh - 220px);}
	.wrapper>footer{height:80px;}

</style>

</head>


<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="./layouts/Header.jsp" %>
		<%@include file="./layouts/Nav.jsp" %>
		<main></main>
		<%@include file="./layouts/Footer.jsp" %>
	</div>
</body>
</html>