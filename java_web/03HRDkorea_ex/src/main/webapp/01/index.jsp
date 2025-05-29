<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Utils.*, java.util.*,java.time.*,java.text.*" %>
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
	td,th{text-align:center;padding:5px 20px;}
</style>

</head>
<%
	List<TeacherDto> list = DBUtils.getInstance().selectAllTeacher();
%>

<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>강사조회</h2>
			<table border=1>
				<tr>
					<th>강사코드</th>
					<th>강사명</th>
					<th>강의명</th>
					<th>수강료</th>
					<th>강사자격 취득일</th>
				</tr>
				<%for(TeacherDto el:list){ %>
				<tr>
					<td><%=el.getTeacher_code()%></td>
					<td><%=el.getTeacher_name()%></td>
					<td><%=el.getClass_name()%></td>
					<%
						DecimalFormat priceform = new DecimalFormat("\\###,###");
						int price = el.getClass_price();
						out.println("<td>"+priceform.format(price)+"</td>");
					%>
					<%
					String date = el.getTeacher_regist_date();
					// 기존 문자 변환
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate ld = LocalDate.parse(date,formatter);
					// 출력용 포멧
					DateTimeFormatter outfmt = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
					out.println("<td>"+ld.format(outfmt)+"</td>");	
					%>
				</tr>
				<%} %>
			</table>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>