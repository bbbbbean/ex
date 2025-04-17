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
			<h1>read</h1>
			<form action="${pageContext.request.contextPath}/book/update" method="post">
				<div>
					<label for="">BookCode</label><span> : ${bookcode_msg }</span> <br />
					<input name="bookcode" placeholder="bookcode" value="${bookDto.bookCode }" readonly/>
				</div>
				<div>
					<label for="">BookName</label><span> : ${bookname_msg }</span> <br />
					<input name="bookname" placeholder="bookname" value="${bookDto.bookName }"/>
				</div>
				<div>
					<label for="">Publisher</label><span> : ${publisher_msg }</span> <br />
					<input name="publisher"  placeholder="publisher" value="${bookDto.publisher }"/>
				</div>
				<div>
					<label for="">isbn</label><span> : ${isbn_msg }</span> <br />
					<input name="isbn" placeholder="isbn" value="${bookDto.isbn }"/>
				</div>
				<!-- 무조건 넘어가는 값, 값이 없어도 넘어감 -->
				<input type="hidden" name="pageno" value='${pageno}'/>
				<button>도서수정</button>
				<a href="${pageContext.request.contextPath}/book/delete?bookcode=${bookDto.bookCode}&pageno=${pageno}">도서삭제</a>
			</form>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>