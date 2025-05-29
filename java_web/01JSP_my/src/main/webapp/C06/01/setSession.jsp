<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// request 속성 추가 (새로운 요청 시마다 초기화)
	request.setAttribute("ID1", "user1");
	request.setAttribute("PW1", "1111");
		
	// session 속성 추가 (지정된 시간까지 유지, 기본 1800초(30분),단 App 종료시 초기화)
	session.setAttribute("ID2","user2");
	session.setAttribute("PW2","2222");

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./getSession.jsp">정보 확인</a>
</body>
</html>