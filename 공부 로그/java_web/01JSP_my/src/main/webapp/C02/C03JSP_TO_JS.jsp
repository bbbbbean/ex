<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- BackEnd 처리 코드 -->
<!-- 1번 처리 부분 -->
<%
	String msg1 = "Hello 1";
	String msg2 = "Hello 2";
	String msg3 = "Hello 3";
	String msg4 = "Hello 4";
	request.setAttribute("message", "TEST");
	request.setAttribute("message2", "TEST!");
%>
    
    
<!-- 2번 처리 부분 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 코드를 java로 확인 예정 -->
	
	<script>
	// 스크립트에 표현식 사용 가능
	// '' 홑따옴표 필수, 빼먹으면 문법 오류 -> 문자열 처리가 되지 않음
<%-- const message1 = '<%=msg1%>';
	const message2 = '<%=msg2%>';
	const message3 = '<%=msg3%>';
	const message4 = '<%=msg4%>'; --%>
	
	// EL표현식 - 요청 파라미터 필요 (msg1, msg2 등)
	// setAttribute - param을 쓰지 않아도 바로 사용 가능
	const message1 = '${message}';
	const message2 = '${message2}';
	
	// 보간법 : JSP의 message값을 리터럴 형태로 변환
	const message3 = `${message}`;
	
	console.log(message1);
	console.log(message2);
	console.log(message3);
	
	</script>
</body>
</html>