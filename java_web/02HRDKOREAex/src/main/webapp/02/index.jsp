<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Utils.*,java.util.*" %>
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
	form{border:1px solid; width:500px;margin:0 auto;}
	main>form>div{display:flex;border-bottom:1px solid;line-height:40px;}
	label{display:block;width:100px;height:40px;border-right:1px solid;text-align:center;line-height:40px;font-weight:600;background-color:lightgray;}
	input{display:block; margin:10px 0 0 20px;height:20px;}
	select{display:block;margin:2px 0 2px 20px;}
	.wrapper>footer{height:80px;}
	button{margin: 10px 0 10px 120px;}

</style>
</head>

<%
	List<MemberDto> list = DBUtils.getInstance().selectAllMember();
%>

<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>투표하기</h2>
			<form name="vote_form" action="./create.jsp" method="post" onsubmit="return false">
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
					<select name="m_no"/>
					<%for(MemberDto dto:list){ %>
						<option value="<%=dto.getM_no()%>"><%="["+dto.getM_no()+"] "+dto.getM_name()%></option>
					<%}%>
					</select>
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
					<input type="radio" name="v_confirm" value="Y"/> 확인
					&nbsp;&nbsp;
					<input type="radio" name="v_confirm" value="N"/> 미확인
				</div>
				<div>
					<!-- url에 결과 뜸 -->
					<button type="submit" onclick="isValid()">투표하기</button>
					<!-- 기입한 input 내용 리셋 -->
					<button type="reset" onclick="javascript:alert('정보를 지우고 처음부터 다시 입력합니다!')">다시하기</button>
				</div>
				<script>
					function isValid(){
						// form 요소 찾기
						var form = document.vote_form; 
						// 유효성 검사
						if(form.v_jumin.value===""){
							alert('주민번호가 입력되지 않았습니다!');
							form.v_jumin.focus();
							return;
						}
						if(form.v_name.value===""){
							alert('성명이 입력되지 않았습니다!');
							form.v_name.focus();
							return;
						}
						if(form.m_no.value===""){
							alert('후보번호가 입력되지 않았습니다!');
							form.m_no.focus();
							return;
						}
						if(form.v_time.value===""){
							alert('투표시간이 입력되지 않았습니다!');
							form.v_time.focus();
							return;
						}
						if(form.v_area.value===""){
							alert('투표장소가 입력되지 않았습니다!');
							form.v_area.focus();
							return;
						}
						if(form.v_confirm.value===""){
							alert('유권자 확인이 선택되지 않았습니다!');
							form.v_confirm.focus();
							return;
						}
						// submit 처리
						form.submit();
					}
				</script>
			</form>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>