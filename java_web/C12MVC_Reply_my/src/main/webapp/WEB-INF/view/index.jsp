<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main  class="layout">
				<h1>HOME</h1>
				${message }
				<%
					// 한번만 메세지를 띄우고 안보이게 하기 위해 새로고침 시 세션에서 해당 메세지 정보 삭제
					// 세션에 정보 담는게 좋긴 한데 많이 담으면 안됨
					session.removeAttribute("message");
				%>
		</main>

		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>
	
<%-- 	<script>
		const message = '<%=request.getParameter("message")!=null?request.getParameter("message"):"" %>
	</script> --%>
	
</body>
</html>