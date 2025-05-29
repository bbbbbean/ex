<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키 확인</h1>
 	<%
		/* 순서가 중요 */
		Cookie[] cookies = request.getCookies();
		/* 최초 요청 시 쿠키가 없을 수도 있음 */
		/* null 체크 */
		if(cookies!=null){
			for(Cookie cookie : cookies){
				System.out.println("cookie : "+cookie.getName()+" : "+cookie.getValue());
				%>
				<div>
					<!-- 쿠키 삭제 : 특정 쿠키 선택 후 삭제 -->
					<a href="./deleteCookie.jsp?cookieName=<%=cookie.getName() %>">
						<%=cookie.getName() %> : <%=cookie.getValue() %> 
					</a>
				</div>
				<%
			}
		}
	%>
	<hr />
	<h1>쿠키 값만 확인 - EL표현식</h1>
	<!-- 내가 원하는 쿠키 값(이름)만 전달하면 됨 -->
<%--
 	Cookie : ${cookie.myCookie1.value } <br />
	Cookie : ${cookie.myCookie2.value } <br />
--%>
	
</body>
</html>