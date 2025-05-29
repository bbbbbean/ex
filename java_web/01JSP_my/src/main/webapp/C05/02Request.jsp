<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String protocol = request.getProtocol();
	String serverName = request.getServerName();
	int ServerPort = request.getServerPort();
	String remoteAddr = request.getRemoteAddr();
	String remoteHost = request.getRemoteHost();
	String method = request.getMethod();
	StringBuffer requestURL = request.getRequestURL();
	String requestURI = request.getRequestURI();
	String Browser = request.getHeader("User-Agent");
	String fileType = request.getHeader("Accept");
%>

	프로토콜 : <%=protocol %> <br />
	서버이름 : <%=serverName %> <br />
	서버포트 : <%=ServerPort %> <br />
	고객주소 : <%=remoteAddr %> <br />
	고객이름 : <%=remoteHost %> <br />
	요청함수(방식) : <%=method %> <br />
	요청경로 : <%=requestURL %> <br />
	요청경로 : <%=requestURI %> <br />
	브라우저 : <%=Browser %> <br />
	파일타입 : <%=fileType %> <br />

	<!-- url 과 uri -->
	<!-- URL : 전체 경로 출력 -->
	<!-- URI : 해당 서버 컴퓨터까지는 생략, 문서를 찾기 위한 정보 -->

</body>
</html>