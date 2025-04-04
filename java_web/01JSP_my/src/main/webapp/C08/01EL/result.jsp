<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C04.UserDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	EL (Expression Language) : 내장 객체의 Scope 참조
		pageScope		: 현재 JSP 페이지 내에서만 사용 가능한 속성/기능 (관련 내장 객체 : pageContext)
		requestScope 	: 하나의 요청 처리동안 (관련 내장 객체 : request)
		sessionScope 	: 일정 기간 동안(지정된 혹은 기본값) (관련 내장 객체 : session)
		applicationScope : 프로그램이 종료되기 전, 서버 종료시 동안 (관련 내장 객체 : application)
	Scope : 각 영역이 실행되는 동안(유지되는 동안)의 단위
-->
<%
	pageContext.setAttribute("P_ATTR","P_ATTR_VALUE");
	request.setAttribute("R_ATTR","R_ATTR_VALUE");
	session.setAttribute("S_ATTR","S_ATTR_VALUE");
	application.setAttribute("A_ATTR","A_ATTR_VALUE");
	/* 시험장가면 걍,, 세션이랑 application에 다 넣고 불러오기ㅎ.. */
	
	pageContext.setAttribute("DUP","PageContext Value");
	request.setAttribute("DUP","Request Value");
	session.setAttribute("DUP","Session Value");
	application.setAttribute("DUP","Application Value");
%>


	<!-- EL : PARAM -->
	UserName : ${param.username} <br />
	PassWord : ${param.password} <br />
	<hr />
	
	<!-- EL : ATTRIBUTE -->
	<!-- 둘 다 같은 값 더 편한 쪽 쓰기 -->
	PageContext's ATTR : ${P_ATTR} <br />
	PageContext's ATTR : ${pageScope.P_ATTR} <br />
	<hr />
	Request_Context's ATTR : ${R_ATTR} <br />
	Request_Context's ATTR : ${requestScope.R_ATTR} <br />
	<hr />
	Session_Context's ATTR : ${S_ATTR} <br />
	Session_Context's ATTR : ${sessionScope.S_ATTR} <br />
	<hr />
	Application_Context's ATTR : ${A_ATTR} <br />
	Application_Context's ATTR : ${applicationScope.A_ATTR} <br />
	<hr />
	<hr />
	
	<!-- EL : ATTRIBUTE(중복값) -->
	Duplicated Value : ${DUP} <br />
	<!-- app>session>du>re : 범위에 따라 덮어쓰기 됨 좁은 범위를 따름 -->
	<hr />
	<hr />
	
	<!-- EL : OBJECT -->
<%
	// EL : 속성으로 넣지 않으면 사용하지 못함
	UserDto userDto = new UserDto("user1","1234","ROLE_USER");
	request.setAttribute("userDto", userDto);
%>
 	표현식 : <%=userDto.getUserid() %> <br />
 	EL : ${userDto.userid } <br />
 	<hr />
	<hr />
 	
 	<!-- EL : 연산자 -->
 	연산 : <%=1+"1" %> <br />		<!-- ""안에 넣으면 문자열 처리 -->
	EL  : ${1+"1"} <br />		<!-- ""안에 넣으면 자동 파싱 -->
	<hr />
	<hr />
	
	<!-- Null Check -->
	Null : ${null } <br />
	empty Null : ${empty null} <br /> <!-- "" == null -->
	<!-- 부정 연산자 먹힘 -->
	empty Null : ${empty TEST} <br />
	empty not Null : ${!empty TEST} <br />
	
	
	
	<hr />
	<hr />
	
	
	
	
	
	
	
	
	
</body>
</html>