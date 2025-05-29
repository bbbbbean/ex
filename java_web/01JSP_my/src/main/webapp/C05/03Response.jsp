<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 던지는 방식에 따라 브라우저에 띄우거나 다운로드 처리하거나 다양하게 처리됨 -->
<%
	/* response.sendRedirect("./02Request.jsp"); */
	
	/* 에러 : sendError : 상태 코드에 따라 예외 페이지 표시, 에러 페이지로 유도한다, 에러 메세지를 표시할 수 있다. */
	/* 408 */
	/* response.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT,"메세지 함께 보낼 수 있음."); */
	/* 404 */
	/* response.sendError(HttpServletResponse.SC_NOT_FOUND, "해당 페이지를 찾을 수 없습니다."); */
	/* 403 */
	/* response.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 금지"); */
	/* 5xx */
	/* response.sendError(HttpServletResponse.SC_BAD_GATEWAY, "서버 장애"); */

	/* 3초마다 새로고침 : 시간 지정 가능 */
	/* response.setIntHeader("Refresh",3); */
	
	/* OutStream 추출 */
	/* ServletOutputStream 자료형으로 받아냄 */
	/* 스트림 처리가 됨 */
	/* ServletOutputStream bout = response.getOutputStream();
	bout.write('a');
	bout.write(98);	// b
	bout.flush();
	bout.close(); */
	
	/* out 내장 객체 */
	/* java.io.* import */
	/* 변수명 out 쓰면 안됨 */
	/* 문서라 생각하고 html 코드를 던질 수 있음 */
	PrintWriter o = response.getWriter();
	o.write("<h1>Hello World</h1>");
	

	
	
	
	
	
	
%>
<!-- 새로고침 확인용 시간 띄우기 -->
<%@page import="java.util.*" %>
<%=new Date() %>


</body>
</html>