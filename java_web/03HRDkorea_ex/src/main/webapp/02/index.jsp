<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Utils.*,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	:root{}
	*{box-sizing:border-box;}
	body{margin:0;padding:0;background-color:lightgray;}
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
	table{margin:0 auto;}
	select{width:175px;}
</style>

</head>


<body>
	<%
		// 모든 회원 정보 가져오기
		List<MemberDto> member_list = DBUtils.getInstance().selectAllMember();
		List<TeacherDto> teacher_list = DBUtils.getInstance().selectAllTeacher();
		List<ClassDto> class_list = DBUtils.getInstance().selectAllClass();
	%>

	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>수강신청</h2>
			<!-- 폼 안에 테이블 넣기 -->
			<form action="./create.jsp" name="registForm" onsubmit="return false">
				<table border=1>
					<tr>
						<td>수강월</td>
						<td><input type="text" name="regist_month"/>예) 2022년03월 -> 202203</td>
					</tr>
					<tr>
						<td>회원명</td>
						<td>
							<select name="c_name">
								<option selected disabled hidden value="">회원명</option>
								<%for(MemberDto el: member_list){ %>
								<option data-no=<%=el.getC_no() %> value=<%=el.getC_name() %>><%=el.getC_name() %></option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>회원번호</td>
						<td><input type="text" name="c_no" value="" readonly/>예)10001</td>
					</tr>
					<tr>
						<td>강의장소</td>
						<td><input type="text" name="class_area"/></td>
					</tr>
					<tr>
						<td>강의명</td>
						<td>
							<select name="class_name" >
								<option selected disabled hidden value="">강의신청</option>
								<%for(TeacherDto el:teacher_list){ %>
								<option data-teacherCode=<%=el.getTeacher_code() %> data-price=<%=el.getClass_price() %> value=<%=el.getClass_name() %> name="class_name"><%=el.getClass_name() %></option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>수강료</td>
						<td>
							<input type="text" name="tuition" readonly/>원
							<!-- teacher-code 숨겨서 보내기 : 액션 코드 사용을 위한 파라미터 전송 -->
							<input type="hidden" name="teacher_code" />
						</td>
					</tr>
					<tr>
						<td colspan=2>
							<button type="submit" onclick="isValid()">수강신청</button>
							<button onclick="resetform()">다시쓰기</button>
						</td>
					</tr>
				</table>
			</form>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
	<script>
		const form = document.registForm;
		let cno;
		let cprice
		// select 옵션 변경 이벤트 - 회원번호
		form.c_name.addEventListener('change',function(e){
			const selectEl = e.target;	// select를 찾음
			const selectedOption = selectEl.options[selectEl.selectedIndex];	// 선택한 옵션 보여줌
			cno = selectedOption.getAttribute('data-no');	// data-no 값 꺼냄
			form.c_no.value=cno;
			
			// 중간에 회원명이 바뀌어도 가격도 따라 바뀌게 - 추가옵션
			if(cprice!=null || cprice!=undefined){
				if(cno<20000)
					form.tuition.value=cprice;
				else
					form.tuition.value=(cprice/2);
			}
		})
		
		// select 옵션 변경 이벤트 - 강의명
		form.class_name.addEventListener('change',function(e){
			const selectEl = e.target;
			const selectedOption = selectEl.options[selectEl.selectedIndex];
			cprice = selectedOption.getAttribute('data-price');
			const teacherCode = selectedOption.getAttribute('data-teacherCode');
			form.teacher_code.value = teacherCode;
			console.log(teacherCode)
			
			if(cno<20000)
				form.tuition.value=cprice;
			else
				form.tuition.value=(cprice/2);
		})
		
		function isValid(){
			if(form.regist_month.value===""){
				alert("수강월을 입력하세요")
				form.regist_month.focus();
				return;
			}
			if(form.c_name.value===""){
				alert("회원명을 선택하세요")
				form.c_name.focus();
				return;
			}
			if(form.class_area.value===""){
				alert("강의장소를 입력하세요")
				form.class_area.focus();
				return;
			}
			if(form.class_name.value===""){
				alert("강의를 선택하세요")
				form.class_name.focus();
				return;
			}
			form.submit();
		}
		function resetform(){
			alert("모든 정보를 지우고 처음부터 다시 입력합니다!");
			form.reset();
		}
	</script>
</body>
</html>