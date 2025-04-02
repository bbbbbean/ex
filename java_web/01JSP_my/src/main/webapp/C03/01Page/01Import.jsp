<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.Scanner,C03.SimpleDto" %>
<!-- .* : 전체 파일 불러오기 -->
<!-- ,(쉼표) : 파일 구분 -->

<%
	/* 기존 사용법 */
	/* java.util.Sacnner sc = new java.util.Scanner(System.in); */
	
	/* import 후 아는 방식으로 사용 가능 */
	Scanner sc = new Scanner(System.in);
	SimpleDto dto = new SimpleDto("홍길동",55,"대구");
	System.out.println("DTO : "+dto);
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	name : <%=dto.getName() %> <br />
	age : <%=dto.getAge() %> <br />
	addr : <%=dto.getAddr() %> <br />
</body>
</html>