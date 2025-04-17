<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, Domain.Dto.*" %>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	PageDto pageDto = request.getAttribute("pageDto")!=null?(PageDto)request.getAttribute("pageDto"):null;
	String type = null;
	String keyword = null;
	if(pageDto!=null){
		type=pageDto.getCriteria().getType();
		keyword=pageDto.getCriteria().getKeyword();
	}
%>

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
					Total : <%=pageDto.getTotalCount() %> <br />
					Page : <span><%=pageDto.getCriteria().getPageno() %></span> / <span><%=pageDto.getTotalpage() %></span> (현재페이지 / 전체 페이지)
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
						
						<%
							List<BookDto> list = request.getAttribute("list")!=null?(List<BookDto>)request.getAttribute("list"):null;
							if(list==null){
								out.print("<td colspan=4>조회할 데이터가 없습니다.</td>");
							}else{
								for(BookDto el : list){%>
									<tr>
										<td><%=el.getBookCode() %></td>
										<td>
											<!-- read에서 정보 판별을 위한 PK키 넘기기, select에 쓸 수 있는 키를 생각하기 -->
											<a href="${pageContext.request.contextPath }/book/read?bookcode=<%=el.getBookCode()%>&pageno=<%=pageDto.getCriteria().getPageno()%>">
												<%=el.getBookName() %>
											</a>
										</td>
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
								  
								    <% if(pageDto!=null&&pageDto.isPrev()){ 
								    	if(type == null || type.isEmpty()){%>
								  	<!-- 이전 버튼 -->
								  	<!-- 이번 블럭의 마지막 숫자로 넘어가게 설정 : -1 -->
								  	<!-- 이전 블럭의 첫번째 숫자로 넘어가게 설정 -->
								    <li class="page-item">
								      <a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=pageDto.getStartPage()-pageDto.getPagePerBlock()%>" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <%}else{%>
								    <li class="page-item">
								      <a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=pageDto.getStartPage()-pageDto.getPagePerBlock()%>&type=<%=type%>&keyword=<%=keyword%>" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>	
								    	<%}
								    } %>
								    
								    <%
								    	// 블럭 당 표시할 시작번호 끝번호
								    	if(pageDto!=null){
								    		int startNo = pageDto.getStartPage();
								    		int endNo = pageDto.getEndPage();
								    		for(int i=startNo;i<=endNo;i++){
								    			// 검색 X의 경우
								    			if(type == null || type.isEmpty()){%>
								    			<!-- 페이지 넘버 설정했으면 컨트롤러와 연결 -->
								    			<li class="page-item">
								    				<a class="page-link" href="${pageContext.request.contextPath }/book/list?pageno=<%=i%>">
								    					<%=i %>
								    				</a>
								    			</li>
								    		<%}else{%>
								    			<li class="page-item">
								    				<a class="page-link"
								    					href="${pageContext.request.contextPath }/book/list?pageno=<%=i%>&type=<%=type%>&keyword=<%=keyword%>">
								    					<%=i %>
								    				</a>
								    			</li>
								    			<%}
								    		}
								    	}
								    %>
								    
								    
								    
									<%if(pageDto!=null&&pageDto.isNext()){ 
										if(type == null || type.isEmpty()){%>
									<!-- 이후 버튼 -->
								    <li class="page-item">
								    	<!-- 현재 번호 +1하면? 다음번호 -->
								      <a class="page-link"
								      	 href="${pageContext.request.contextPath }/book/list?pageno=<%=pageDto.getEndPage()+1%>"
								      	 aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
								    <%}else{%>
								    <li class="page-item">
								    	<!-- 현재 번호 +1하면? 다음번호 -->
								      <a class="page-link"
								      	 href="${pageContext.request.contextPath }/book/list?pageno=<%=pageDto.getEndPage()+1%>&type=<%=type%>&keyword=<%=keyword%>"
								      	 aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>	
								    	<%}
								    } %>
								  </ul>
								</nav>
							</td>
							<td>
								<!-- 글쓰기 -->
								<a href="${pageContext.request.contextPath }/book/create" class="btn btn-success">도서등록</a>
								<!-- 처음으로 -->
								<a href="${pageContext.request.contextPath }/book/list" class="btn btn-secondary">처음으로</a>
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