<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C09.*,C04.*" %>
<%
	// param 받아오기
	String userid = request.getParameter("userid");

	// DB 연결
	DBUtils dbutils = DBUtils.getInstance();
	
	// delete 실행
	int delete = dbutils.deleteUser(userid);
	
	// DB연결 + delete 실행
	int result = DBUtils.getInstance().deleteUser(userid);
	
	// 삭제 시 삭제 재확인 알림 띄우기

	// 이동 (redirect or forwarding or script 코드 처리(location.href=))
	response.sendRedirect("./selectAll.jsp");
	
	
/* 	if(delete>0)
		out.println("<script>alert('delete 성공');location.href='./selectAll.jsp'</script>");
	else
		out.println("<script>alert('delete 실패');location.href='./selectAll.jsp'</script>");
 */
%>