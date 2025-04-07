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
	.wrapper>main{height:calc(100vh - 220px);}
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
	<!--
		조회 쿼리문
		select m_no, m_name, p_name,p_school,m_jumin,M_city,p_tel1,p_tel2,p_tel3
		from tbl_member_202005
		join tbl_party_202005
		on tbl_member_202005.p_code=tbl_party_202005.p_code;
	-->
	<%@ page import="Utils.*,java.util.*" %>
	<%
		List<MemberDto> list = DBUtils.getInstance().selectAllMember();
	%>

	<div class="wrapper">
		<!-- 헤더 -->
		<%@include file="/layouts/Header.jsp" %>
		<%@include file="/layouts/Nav.jsp" %>
		<main>
			<h2>후보조회</h2>
			<table border=1 border-collapse=collapse;>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
				<%for(MemberDto dto:list){ %>
				<tr>
					<td><%=dto.getM_no() %></td>
					<td><%=dto.getM_name() %></td>
					<td><%=dto.getP_name() %></td>
					<% 
						String school = dto.getP_school();
						switch(school){
						case "1":
							out.print("<td>고졸</td>");
							break;
						case "2":
							out.print("<td>학사</td>");
							break;
						case "3":
							out.print("<td>석사</td>");
							break;
						case "4":
							out.print("<td>박사</td>");
							break;
					}
					%>
					<td><%
						StringBuffer sb = new StringBuffer();
						sb.append(dto.getM_jumin());
						sb.insert(6,'-');
						out.print(sb);
					%></td>
					<td><%=dto.getM_city() %></td>
					<td><%=dto.getP_tel1()+'-'+dto.getP_tel2()+'-'+dto.getP_tel3() %></td>
				</tr>
				<%} %>
			</table>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>