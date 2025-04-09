<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Utils.*,java.util.*,java.text.*" %>
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
	.right{text-align:right;padding-right:0;}
</style>

</head>
<%
	List<TeacherClassDto> list = DBUtils.getInstance().SelectTeacherInfo();
%>

<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>강사매출현황</h2>
			<table border=1>
				<tr>
					<th>강사코드</th>
					<th>강의명</th>
					<th>강사명</th>
					<th>총매출</th>
				</tr>
				<%for(TeacherClassDto el:list){ %>
				<tr>
					<td><%=el.getTeacher_code() %></td>
					<td><%=el.getClass_name() %></td>
					<td class="right"><%=el.getTeacher_name() %></td>
					<%
						DecimalFormat price = new DecimalFormat("\\###,###");
						int tuition = el.getSumTuition();
						String sum = price.format(tuition);
					%>
					<td class="right"><%=sum %></td>
				</tr>
				<%} %>
			</table>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>