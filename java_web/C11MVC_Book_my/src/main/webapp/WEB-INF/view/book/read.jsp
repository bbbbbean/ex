<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<!-- 프로젝트 경로 포함 -->
	<%@include file="/resources/layouts/link.jsp" %>
	
	<!-- css link -->
	<!-- 프로젝트 경로가 빠져있음, 꼭 적어주기 직접 접근 -->
	<!-- 제대로 생성됐는지 확인 -> 주소창에 경로 쳐보기 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/book/read.css" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/book/read.js" defer></script>
	
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
			<h1 class="mt-3">read</h1>
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
				<div class="mb-3">
					<label for="">isbn</label><span> : ${isbn_msg }</span> <br />
					<input name="isbn" placeholder="isbn" value="${bookDto.isbn }"/>
				</div>
				<!-- 무조건 넘어가는 값, 값이 없어도 넘어감 -->
				<input type="hidden" name="pageno" value='${pageno}'/>
				<button class="btn btn-success">도서수정</button>
				<a href="${pageContext.request.contextPath}/book/delete?bookcode=${bookDto.bookCode}&pageno=${pageno}" class="btn btn-secondary">도서삭제</a>
			</form>
			<!-- 댓글란 -->
			<div class="reply-block mt-5">
				<div class="reply-header">
					<div>
						댓글수 : <span>00</span>
					</div>	
					<hr />
					<!-- 댓글 입력 부분 -->
					<div>
						<textarea name="" id="" cols="30" rows="5"></textarea>
						<a href="javascript:void(0)" class="btn btn-success reply-add-btn">입력</a>
					</div>
				</div>
				<!-- 생성 댓글 확인 부분 -->
				<div class="reply-body">
					<div class="items">
						<div class="item">
							<div class="left">
								<div class="profile"></div>
								<div>username</div>
							</div>
							<div class="right">
								<div class="date">2025-01-01</div>
								<div class="content">
									<textarea name="" id="" cols="30" rows="2"></textarea>
								</div>
								<div class="button-group"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>