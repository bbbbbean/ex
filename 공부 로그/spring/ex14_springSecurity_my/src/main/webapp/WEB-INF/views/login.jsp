<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Login</h1>
	<!-- 시큐리티 처리 시 POST 방식 -->
	<!-- 기본 login방식 따라 만드는 중, name들 변경 가능 -->
	<form action="${pageContext.request.contextPath}/login" method="post">
		<div>
			<label>UserName : </label>
			<input name="username" />
		</div>
		<div>
			<label>PassWord : </label>
			<input name="password" type="password" />
		</div>
		<div>
			<input type="checkbox" name="remember-me" id="remember-me">
			<label>로그인 상태 유지</label>
		</div>
		<button>로그인</button>
		<!-- 토큰 값을 전달해야 로그인이 됨 -->
		<%-- <input type="hidden" name="_csrf" value="${_csrf.token}" />	 --%>	
	</form>
	${message}
	${param.error }
		
</body>
</html>