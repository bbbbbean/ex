<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C09.*, C04.*, java.util.*, java.time.format.DateTimeFormatter" %>
    
<!--
	품목별 총합 (총합별 내림차순)
	** join, group by는 시험에 나오니까 잘 알아두기
	select category, sum(price*quantity)
	from tbl_order
	group by category
	having sum(price*quantity)>=50000
	order by sum(price*quantity) desc;
-->
<%
	List<OrderDto> list = DBUtils.getInstance().selectAllOrder();
%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 품목별 총액 (50000원 이상)</h1>
	<%
	
	%>
	<table>
		<tr>
			<th>품목</th>
			<th>총합</th>
		</tr>
		
		<%for(OrderDto el : list){%>
		<tr>
			<td><%=el.getCategory() %></td>
			<td><%=el.getSum() %></td>
		</tr>
		<%}%>
	</table>
	
	<hr />
	
	<h1>날짜별 구매 총 평균</h1>
	<!-- select order_date,round(avg(price*quantity),2)  -- 결과값 2자리수 까지만 표기
	from tbl_order
	group by order_date; -->
	<%
	List<OrderDto2> list2 = DBUtils.getInstance().selectAllOrder2();
	%>
	<table>
		<tr>
			<th>주문 날짜</th>
			<th>평균 구매액</th>
		</tr>
		<!-- 기본 날짜 포맷 : 2025-04-06 -->
		<!-- 날짜 포맷 수정법 -->
		<%for(OrderDto2 el : list2){
			// yyyy.MM.dd
			// import 경로 모를때? java에서 import한 뒤 긁어오기
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy~MM~dd");
		%>
		<tr>
			<td><%=el.getOrder_date().format(formatter) %></td>
			<td><%=el.getAverage() %></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>