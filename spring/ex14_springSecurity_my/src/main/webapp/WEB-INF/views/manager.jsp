<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Manager</h1>
	<!-- PW가 노출 됨 -> 토큰 방식으로 인증 변경 예정 -->
	<!-- 속성명 잘 적어주면 확인 가능 -->
	<p>Principal	: <sec:authentication property="principal" /> </p>
	<p>UserDto		: <sec:authentication property="principal.userDto" /> </p>
	<p>Principal로 꺼낸 ID	: <sec:authentication property="principal.username" /> </p>
	<p>사용자의 이름 : <sec:authentication property="principal.userDto.username" /> </p>
	<p>사용자의 아이디 : <sec:authentication property="principal.userDto.username" /> </p>
	<p>사용자의 권한 목록 : <sec:authentication property="principal.userDto.role" /> </p>
	
	<sec:authorize access="isAuthenticated()">
		<p>로그인 사용자입니다.</p>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<p>비로그인 사용자입니다. 로그인해주세요.</p>
	</sec:authorize>
	
	
	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	
</body>
</html>