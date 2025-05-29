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
 	.wrapper>main>section{min-height:500px;}
	
	.wrapper>footer{min-height:250px;}
</style>

</head>
<body>
	<div class="wrapper">
		<header>
			<!-- top-header insert 지시자 이용해서 가져오기 -->
			<%@ include file="./layout/topHeader.jsp" %>
			<!-- nav Insert 지시자 이용해서 가져오기 -->
			<%@ include file="./layout/nav.jsp" %>
		</header>
		<main>
			<section>
				<h1>Login</h1>
				<form action="login.jsp" method="post">
					<input type="text" name="userid" /><br> 
					<input type="text"name="password" /><br> 
					<input type="submit" value="로그인" />
				</form>
			</section>

		</main>

		<footer>
			<!-- footer insert 지시자 이용해서 가져오기 -->
			<%@ include file="./layout/footer.jsp" %>
		</footer>
	</div>

</body>
</html>