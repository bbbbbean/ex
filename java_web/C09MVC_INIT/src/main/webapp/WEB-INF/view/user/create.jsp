<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/user/create" method="post">
		<!-- 파라미터 연결 잊지말기 -->
		UserName : <input type="text" name="username"/> <br />
		PassWord : <input type="text" name="password"/> <br />
		<button>회원가입</button>
	</form>
	<div>
		${username_err}
	</div>
	
</body>
</html>