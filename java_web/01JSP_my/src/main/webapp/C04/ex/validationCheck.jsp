<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errors.jsp"%>
<%@ page import = "C04.UserDto" %>

<%
	// request로부터 전달받은 파라미터 꺼내서 System.out 확인
	// 받은 username,password 값이 null인지여부를 체크(String API trim()  + isEmpty() 이용)
	// 에러 발생 시 처리 페이지로 전달
	UserDto userDto = (UserDto)request.getAttribute("userDto");
	System.out.println("[validationCheck] userDto : "+userDto);
	if(userDto == null)
		throw new Exception("userDto가 null입니다");
	if(userDto.getUserid().trim().isEmpty())
		throw new Exception("userid를 입력하세요");
	if(userDto.getPassword().trim().isEmpty())
		throw new Exception("password를 입력하세요");
	if(userDto.getRole().trim().isEmpty())
		throw new Exception("기본역할(role)이 지정되지 않았습니다.");
	
	// 에러 미발생시 dbUtils.jsp로 해당 내용 Forwarding
	request.setAttribute("url","/join");	// DB 요청 처리 insert
	request.setAttribute("serviceNo",1);	// ServiceNo C=1 R=2 U=3 D=4
	request.getRequestDispatcher("./dbUtils.jsp").forward(request,response);
%>
