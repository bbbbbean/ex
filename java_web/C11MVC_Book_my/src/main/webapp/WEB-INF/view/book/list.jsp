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
			<h1>list</h1>
			<!-- 게시글 필터(전체/이름/출판사/isbn) -->
			<section>
			
			</section>
			
			<!-- 게시글 표시 -->
			<section>
				<div>
					Page : <span>1</span> / <span>100</span> (현재페이지 / 전체 페이지)
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>도서코드</th>
							<th>도서명</th>
							<th>출판사</th>
							<th>ISBN</th>
						</tr>
					</thead>
					<tbody>
						<%@page import="java.util.*, Domain.Dto.*" %>
						<%
							List<BookDto> list = request.getAttribute("list")!=null?(List<BookDto>)request.getAttribute("list"):null;
							if(list==null){
								out.print("<td colspan=4>조회할 데이터가 없습니다.</td>");
							}else{
								for(BookDto el : list){%>
									<tr>
										<td><%=el.getBookCode() %></td>
										<td><%=el.getBookName() %></td>
										<td><%=el.getPublisher() %></td>
										<td><%=el.getIsbn() %></td>
									</tr>
								<%}
							}
						%>
					</tbody>
					<tfoot>
						<tr>
							<td colspan=3>
								<nav aria-label="Page navigation example">
								  <ul class="pagination">
								  <%
								    	PageDto pageDto = request.getAttribute("pageDto")!=null?(PageDto)request.getAttribute("pageDto"):null;
								    %>
								    <% if(pageDto!=null&&pageDto.isPrev()){ %>
								  	<!-- 이전 버튼 -->
								    <li class="page-item">
								      <a class="page-link" href="#" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <%} %>
								    
								    <%
								    	// 블럭 당 표시할 시작번호 끝번호
								    	if(pageDto!=null){
								    		int startNo = pageDto.getStartPage();
								    		int endNo = pageDto.getEndPage();
								    		for(int i=startNo;i<=endNo;i++){%>
								    			<li class="page-item"><a class="page-link" href="#"><%=i %></a></li>
								    		<%}
								    	}
								    %>
								    
								    
								    
									<%if(pageDto!=null&&pageDto.isNext()){ %>
									<!-- 이후 버튼 -->
								    <li class="page-item">
								      <a class="page-link" href="#" aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
								    <%} %>
								  </ul>
								</nav>
							</td>
							<td>
								<!-- 글쓰기 -->
								<a href="javascript:void(0)" class="btn btn_success">도서등록</a>
								<!-- 처음으로 -->
								<a href="javascript:void(0)" class="btn btn_secondary">처음으로</a>
							</td>
						</tr>
					</tfoot>
				</table>
				
			</section>
			
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>