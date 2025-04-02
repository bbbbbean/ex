<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* 시험장에서 외부 파일로 빼서 부르지 말고 그냥 여기서 짜기 */
	/* 세부는 include파일에서 이렇게 */
	:root{}
	*{box-sizing:border-box;padding:10px;border:1px solid;}
	a{}
	ul{}
	body{padding:0;margin:0;}
	.wrapper{}
	
	.wrapper>header{min-height:100px;}
	.wrapper>header>.top-header{min-height:25px;}
	.wrapper>header>nav{min-height:75px;}
	
	.wrapper>main{min-height:calc(100vh - 100px - 250px);}
 	.wrapper>main>section{min-height:700px;}
	
	.wrapper>footer{min-height:250px;}
</style>

</head>
<body>
	<!-- 기본 구조 하나 외워두기 : .wrapper>header>.top-header+nav^main>section^footer -->
	<div class="wrapper">
		<!-- header, footer : 변하지 않는 고정 요소 -> 다른 페이지로 빼서 불러옴 -->
		<header>
<!-- 		<div class="top-header">Top-header 영역</div>-->
			<%@ include file="./layout/TopHeader.jsp" %>
<!-- 		<nav>Nav 영역</nav> -->
			<%@ include file="./layout/Nav.jsp" %>
		</header>

<!-- 자주 바뀌는 부분만 남기고 빼기 -->
		<main>
			<section>Main 영역</section>
		</main>
		
<!-- 	<footer>Footer 영역</footer> -->
		<%@ include file="./layout/Footer.jsp" %>
	</div>
</body>
</html>