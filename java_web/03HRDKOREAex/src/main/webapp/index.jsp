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
	li{margin:0; padding:0;}
	a{text-decoration:none; color:black;}

	.wrapper{}
	.wrapper>header{height:100px;}
	.wrapper>nav{height:40px;}
	.wrapper>main{height:calc(100vh - 320px);}
	.wrapper>footer{height:80px;}
	
	h2{
		margin-top:100px;
		text-align:center;
		font-size:1.8rem;
		font-weight:400;
	}
	main>ul{display:flex;flex-direction:column;margin-left:30px;}
	main>ul>li:first-child{margin-top:50px;}

</style>

</head>


<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="./layouts/Header.jsp" %>
		<%@include file="./layouts/Nav.jsp" %>
		<main>
			<h2>과정평가형 자격 CBQ</h2>
			<ul>
				무언가의 내용이 들어있음
				<li>내용</li>
				<li>내용</li>
				<li>내용</li>
				<li>내용</li>
			</ul>
		</main>
		<%@include file="./layouts/Footer.jsp" %>
	</div>
</body>
</html>