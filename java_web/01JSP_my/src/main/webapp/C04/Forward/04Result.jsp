<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* request로 파라미터 받아오기 */
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	/* 02 내용 꺼내기 */
	String Page02Value = (String)request.getAttribute("02Page");
	
	/* 03 내용 꺼내기 */
	String Page03Value = (String)request.getAttribute("03Page");
	
	/* 콘솔 출력 */
	/* request 내용은 01의 것 유지 == 03에서 확인가능 */
	/* 2를 거치면서 02 내용 전부 작동 -> 02 내용과 03내용 전부 콘솔 확인 가능 */
	System.out.println("---------RESULT---------");
	System.out.println("username : "+username);
	System.out.println("password : "+password);
	System.out.println("02 PageValue : "+Page02Value);
	System.out.println("03 PageValue : "+Page03Value);
	System.out.println("------------------------");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 최종 페이지만 브라우저로 출력 : 중간 과정 02,03은 document 이하 절이 필요없음 -->
	<h1>Result</h1>
	<%=username %> <br />
	<%=password %> <br />
	<%=Page02Value %> <br />
	<%=Page03Value %> <br />
</body>
</html>