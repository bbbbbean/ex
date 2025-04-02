<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="02Error.jsp" %>
    <!-- errorPage 지정 시 겹따옴표로 꼭 묶기 -->
    
<%
	/* 참고용 : 시험에는?안나옴 */
	/* request로 요청 파라미터 꺼냄 */
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	/* .isEmpty() : 문자열 null판단 */
	/* Exception 던짐 - 그냥 모든 정보가 뜨는 페이지 출력 -> 만든 예외 페이지로 넘기는 작업을 할 수 있음 */
	if(name.isEmpty())
		throw new Exception("이름을 입력하세요");
	if(age.isEmpty())
		throw new Exception("나이를 입력하세요");
	if(addr.isEmpty())
		throw new Exception("주소를 입력하세요");

%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <%=name %> <br />
	나이 : <%=age %> <br />
	주소 : <%=addr %> <br />
</body>
</html>