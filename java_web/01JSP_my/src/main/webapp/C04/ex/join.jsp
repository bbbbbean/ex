<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "C04.UserDto" %>

<!--  
		UserDto객체에 전달받은 파라미터(userid,password)를 저장
		request에  setAttribute로 userDto 저장("userDto",userDto);
		02ValidationCheck.jsp 로 forwarding
-->
<%
	// userDTO 객체 생성
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	UserDto userDto = new UserDto(userid,password,"Role_user");
	
	// request 내장객체 userDto 추가
	request.setAttribute("userDto",userDto);

	// forwoarding
	request.getRequestDispatcher("./validationCheck.jsp").forward(request,response);
	
%>