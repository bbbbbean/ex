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
			<form action="${pageContext.request.contextPath}/book/create" method="post">
				<div>
					<label for="">BookCode</label><span> : ${bookcode_msg }</span> <br />
					<input name="bookcode" placeholder="bookcode"/>
				</div>
				<div>
					<label for="">BookName</label><span> : ${bookname_msg }</span> <br />
					<input name="bookname" placeholder="bookname"/>
				</div>
				<div>
					<label for="">Publisher</label><span> : ${publisher_msg }</span> <br />
					<input name="publisher"  placeholder="publisher"/>
				</div>
				<div>
					<label for="">isbn</label><span> : ${isbn_msg }</span> <br />
					<input name="isbn" placeholder="isbn" />
				</div>
				<button>책 추가하기</button>
			</form>
			<div>
				<!-- 에러 문구란 -->
				${bookcode_err}
			</div>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>