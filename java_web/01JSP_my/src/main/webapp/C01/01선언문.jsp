<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언문 : 서블릿으로 변환되는 자바파일의 속성/기능을 추가 -->
<%!
	// 백엔드에서 처리 -> tomcat으로 변환되어 java로 저장
	// 서블릿 파일의 멤버 변수 (속성)
	String name = "Hong Gil Dong";
	// 서블릿 파일의 멤버 함수 (기능)
	public String testFunc(){
		System.out.println("선언문 TEST");
		return "name : "+name;
	}
	// 만든 속성과 기능을 사용하려면? 표현식 사용
%>
<!--
	서블릿의 결과 객체를 가져옴
	표현식(SERVLET 파일(JAVA파일)) 안의 값을 frontEnd로 전달 표현할 때 사용
-->
NAME : <%=name %> <br/>
testFunc() : <%=testFunc()  %> <br/>

<!-- 
	서블릿 파일 생성 위치
	C:\정처산기공유\06_java\java_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\01JSP\org\apache\jsp\C01
	workspace--------------------\
 -->
</body>
</html>