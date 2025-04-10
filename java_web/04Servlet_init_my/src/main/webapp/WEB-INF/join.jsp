<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<!-- '/join.do' 똑같은 파일에서 get, post 두가지 방식 다 사용가능 -->
	<!-- post 처리 함수를 해당 서블릿 파일에 만들어주기 -->
	<form action="${pageContext.request.contextPath}/join.do" method="post">
		<input type="text" name="username"/> <br />
		<input type="text" name="password"/> <br />
		<button>회원가입</button>
	</form>
</body>
</html>