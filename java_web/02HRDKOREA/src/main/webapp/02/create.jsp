<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Utils.*" %>


<%
	// 파라미터 받기 : 기본, 가장 정확한 방법
	String jumin = request.getParameter("v_jumin");
	String name = request.getParameter("v_name");
	String no = request.getParameter("m_no");
	String time = request.getParameter("v_time");
	String area = request.getParameter("v_area");
	String confirm = request.getParameter("v_confirm");
	
	VoteDto voteDto = new VoteDto(jumin, name, no, time, area, confirm);
	System.out.println("voteDto : "+voteDto);
%>


<!--
	파라미터 받기(액션 태그) : useBean = 객체 생성 가능?
	조건 : Dto, input name 이름 동일 / Dto 생성자, getter, setter 필수 생성
-->
<%
	// VoteDto voteDto2 = new VoteDto(); 아래 useBean과 같은 역할
%>
<jsp:useBean id="voteDto2" class="Utils.VoteDto" scope="request"/>
<jsp:setProperty name="voteDto2" property="*" />
<%
	System.out.println("voteDto2 : "+voteDto2);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>