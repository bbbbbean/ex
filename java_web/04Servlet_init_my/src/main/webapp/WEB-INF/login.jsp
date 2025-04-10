<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<!-- post 처리 함수를 해당 서블릿 파일에 만들어주기 -->
	<!-- post 처리 시 이동될 파일에서 post를 받아 처리해줄 필요가 있음 -->
	<!-- 다시 login폼으로 보내서 유효성 검사, DB 정보와 일치 여부 판단 등을 한 뒤 거기서 main으로 보내기 -->
	<form action="${pageContext.request.contextPath}/login.do" method="post">
		<input type="text" name="username"/> <br />
		<input type="text" name="password"/> <br />
		<button>로그인</button>
	</form>
	<div>${username_mag}</div>
	<div>${password_mag}</div>
</body>
</html>