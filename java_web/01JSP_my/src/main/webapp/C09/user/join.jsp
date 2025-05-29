<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- import 잘하기!!!! -->
<%@ page import="C09.DBUtils, C04.*" %>
<%
	// 파라미터 받아오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String role = "ROLE_USER";
	
	// 입력값 검증 (생략)
	// 서비스 실행 (DB insert)
	DBUtils dbUtils = DBUtils.getInstance();
	int result = dbUtils.insertUser(new UserDto(userid,password,role));
	
	// 이동 (redirect or forwarding or script 코드 처리(location.href=))
	if(result>0)
		out.println("<script>alert('insert 성공');location.href='../index.jsp'</script>");
	else
		out.println("<script>alert('insert 실패');location.href='./join_form.jsp'</script>");
%>