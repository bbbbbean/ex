<%
	/* 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%> 

<!-- 개량 표현식 : EL -->
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body style="background-color:${param.bgcolor}">

	EL_USERNAME : ${param.username} <br />
	EL_PASSWORD : ${param.username} <br />

</body>
</html>