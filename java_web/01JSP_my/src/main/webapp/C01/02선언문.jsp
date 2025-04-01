<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	// tomcat이 구동하는 동안은 값 동일
	int n = 0;
	public int countUp(){
		n++;
		return n;
	}
	// 안에 반복문 불가 -> class 내에 반복문 쓴 적 있음? X, 문법 오류
	%>
	<%=countUp() %>
</body>
</html>