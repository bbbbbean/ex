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
	<%@ page import="Utils.*,java.util.*" %>
	<%
		List<ResultDto> list = DBUtils.getInstance().selectAllresult();
	%>

	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>후보자등수</h2>
			<table border=1 border-collapse=collapse;>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				<%for(ResultDto dto:list){%>
				<tr>
					<td><%=dto.getM_no() %></td>
					<td><%=dto.getM_name() %></td>
					<td><%=dto.getM_count() %></td>
				<%}%>
			</table>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>