<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	내장 객체 : 좁은 범위의 영역에서 넓은 범위의 객체를 꺼내올 수 있음

-->
<%
	System.out.println("pageContext : "+pageContext);
	/* 좁은 객체가 더 넓은 범위의 내장 객체를 받아 올 수 있음 확인 */
	System.out.println("pageContext's get request : "+pageContext.getRequest());
	System.out.println("pageContext's get response : "+pageContext.getResponse());
	System.out.println("pageContext's get session : "+pageContext.getSession());
	System.out.println("pageContext's get application : "+pageContext.getServletContext());
	/* 프로젝트 경로 설정 확인 */
	System.out.println("project path : "+pageContext.getServletContext().getContextPath());
%>

<!-- 경로 설정시 tomcat이 프로젝트 경로를 불러오게 설정해야함 -->
<!-- 꼭 프로젝트 경로 넣기! -->
<!-- 아래 action 형식 금지.. 냅다 페이지만 넣기 금지 -->
<form action="01page"></form>

<!-- 표현식 -->
ProjectPath : <%=pageContext.getServletContext().getContextPath() %>
<hr />
ProjectPath(EL) : ${pageContext.request.contextPath }


</body>
</html>