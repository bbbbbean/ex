<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C09.DBUtils,C04.*"%>

<%
	// 파라미터 받아오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String role = request.getParameter("role");
	
	// DB 연결 후 함수 실행
	DBUtils dbutils = DBUtils.getInstance();
	int update = dbutils.updateUser(new UserDto(userid,password,role));
	
	/* 한줄로 줄이는 법 */
	int update2 = DBUtils.getInstance().updateUser(new UserDto(userid,password,role));
	
	// 이동 (redirect or forwarding or script 코드 처리(location.href=))
	if(update>0)
		out.println("<script>alert('update 성공');location.href='./selectAll.jsp'</script>");
	else
		out.println("<script>alert('update 실패');location.href='./selectAll.jsp'</script>");
%>