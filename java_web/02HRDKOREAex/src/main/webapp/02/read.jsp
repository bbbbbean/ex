<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Utils.*,java.util.*,java.time.*,java.time.format.*" %>
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
	table{margin:0 auto;border:1px solid;border-collapse:collapse;}
	tr{margin:0;}
	th{background-color:lightgray;padding:10px;}
	td{
		text-align:center;
		margin:0;
		padding:10px;
	}
	form{border:1px solid; width:500px;margin:0 auto;}
	.wrapper>footer{height:80px;}

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
		<!-- 파라미터 받기:액션태그 -->
		<jsp:useBean id="voteDto2" class="Utils.VoteDto" scope="request"/>
		<jsp:setProperty name="voteDto2" property="*" />
		<main>
			<h2>투표검수조회</h2>
			<table border=1 border-collapse=collapse;>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<tr>
					<td><%=voteDto2.getV_name() %></td>
					<%
						// 나이 뽑아내서 포멧팅
						String birth = voteDto2.getV_jumin().substring(0, 6);	// yyMMdd
						int yy = Integer.parseInt(birth.substring(0,2));
						int now = LocalDate.now().getYear()%100;
						if(yy>0 && yy<=now)
							birth = "20"+birth;
						else
							birth = "19"+birth;
						
						// 입력 포멧(yyyyMMdd) : 아래 포멧으로 날짜를 받음
						DateTimeFormatter infmt = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate myBirth = LocalDate.parse(birth,infmt);	// 로컬 데이터로 변환
						
						// 출력 포멧(yyyy년MM월dd일생)
						DateTimeFormatter outfmt = DateTimeFormatter.ofPattern("yyyy년MM월dd일생");
						
						out.print("<td>"+myBirth.format(outfmt)+"</td>");
					%>
					<%
						// 만나이 계산
						String age = voteDto2.getV_jumin().substring(0, 6);	// yyMMdd
						age = "19"+age; // 199nMMdd로 형식 맞춤
					
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate date = LocalDate.parse(age,formatter);	// 들어온 값 local date화 -> yyyy-MM-dd 형태로 변환
						
						// 현재 날짜
						LocalDate today = LocalDate.now();
						int manAge = Period.between(date,today).getYears();
						
						out.print("<td>만 "+manAge+"세</td>");
					%>
					<%
						char gender = voteDto2.getV_jumin().charAt(6);
						if(gender%2==0)
							out.print("<td>여</td>");
						else
							out.print("<td>남</td>");
					%>
					<td><%=voteDto2.getM_no() %></td>
					<%
						StringBuffer sb = new StringBuffer();
						sb.append(voteDto2.getV_time());
						sb.insert(2,":");
						out.println("<td>"+sb+"</td>");
					%>
					<%
						if(voteDto2.getM_no()=="Y")
							out.print("<td>확인</td>");
						else
							out.print("<td>미확인</td>");
					
					%>
				</tr>
			</table>
		</main>
		<%@include file="/layouts/Footer.jsp" %>
	</div>
</body>
</html>