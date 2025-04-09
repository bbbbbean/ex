<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Utils.*,java.util.*,java.time.format.*,java.time.*,java.text.*" %>
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
	td{padding:5px 10px;}

</style>
</head>
<%
	List<MemberInfoDto> list = DBUtils.getInstance().selectAllMemberInfo();
%>
<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>회원정보조회</h2>
			<table border=1>
				<tr>
					<th>수강월</th>
					<th>회원번호</th>
					<th>회원명</th>
					<th>강의명</th>
					<th>강의장소</th>
					<th>수강료</th>
					<th>등급</th>
				</tr>
				<%for(MemberInfoDto el:list){ %>
				<tr>
					<%
						String date = el.getRegist_month();
						date = date+"01";
						// 데이터 로컬화
						DateTimeFormatter inform = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate classdate = LocalDate.parse(date,inform);
						// 출력 폼
						DateTimeFormatter outform = DateTimeFormatter.ofPattern("yyyy년MM월");
						out.println("<td>"+classdate.format(outform)+"</td>");
					%>
					<td><%=el.getC_no() %></td>
					<td><%=el.getC_name() %></td>
					<%
						String teacher = el.getTeacher_code();
						String classname = null;
						if(teacher.matches("100")) classname ="초급반";
						else if(teacher.matches("200")) classname ="중급반";
						else if(teacher.matches("300")) classname ="고급반";
						else classname ="심화반";
						out.println("<td>"+classname+"</td>");
					%>
					<td><%=el.getClass_area() %></td>
					<%
					DecimalFormat priceform = new DecimalFormat("\\###,###");
					int price = el.getTuition();
					out.println("<td>"+priceform.format(price)+"</td>");
					%>
					<td><%=el.getGrade() %></td>
				</tr>
				<%} %>
			</table>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>