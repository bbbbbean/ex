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
	.wrapper>main{height:calc(100vh - 320px);}
	.wrapper>main table{
		border:1px solid;
		border-collapse:collapse;
	}
	.wrapper>main table th,
	.wrapper>main table td{
		min-width:80px;
		min-height:35px;
	}
	.wrapper>main h2{
		margin-top:100px;
		text-align:center;
		font-size:1.8rem;
		font-weight:400;
	}
	table{margin:0 auto;}
	tr{margin:0;}
	th{background-color:lightgray;padding:10px;}
	td{
		text-align:center;
		margin:0;
		padding:10px;
	}
	.wrapper>footer{height:80px;}

</style>

</head>


<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>투표하기</h2>
			<form action="./create.jsp" method="post">
				<div>
					<label for="">주민번호</label>
					<input type="text" name="v_jumin"/>
				</div>
				<div>
					<label for="">성명</label>
					<input type="text" name="v_name" />
				</div>
				<div>
					<label for="">투표번호</label>
					<input type="text" name="m_no"/>
				</div>
				<div>
					<label for="">투표시간</label>
					<input type="text" name="v_time"/>
				</div>
				<div>
					<label for="">투표장소</label>
					<input type="text" name="v_area"/>
				</div>
				<div>
					<label for="">유권자확인</label>
					<input type="radio" name="v_confirm"/> 확인
					&nbsp;&nbsp;
					<input type="radio" name="v_confirm"/> 미확인
				</div>
				<div>
					<!-- url에 결과 뜸 -->
					<button type="submit">투표하기</button>
					<!-- 기입한 input 내용 리셋 -->
					<button type="reset">다시하기</button>
				</div>
			</form>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>