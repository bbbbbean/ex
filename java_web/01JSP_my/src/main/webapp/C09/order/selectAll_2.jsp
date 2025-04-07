<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C09.*, C04.*, java.util.*,java.time.format.DateTimeFormatter" %>    
    
<!--
	Inner Join
	
	-- 구매한 고객 > 지역별 구매 총액
	select addr, order_date, sum(price*quantity)
	from tbl_user
	join tbl_order
	on tbl_user.userid=tbl_order.userid
	group by addr, order_date
	order by addr, sum(price*quantity) desc;
	
	-- 구매하지 않은 고객
	select tbl_user.userid, addr, quantity from tbl_user
	left outer join tbl_order
	on tbl_user.userid=tbl_order.userid
	where tbl_order.userid is null;
-->

<%
	List<OrderDto3> list = DBUtils.getInstance().selectAllOrder3();
	List<OrderDto4> list2 = DBUtils.getInstance().selectAllOrder4();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역+날짜별 구매 총액</h1>
	<table>
		<tr>
			<th>지역</th>
			<th>날짜</th>
			<th>총액</th>
		</tr>
		<%for(OrderDto3 el : list){
			DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY.MM.dd");
		%>
		<tr>
			<td><%=el.getAddr() %></td>
			<td><%=el.getOrder_date().format(date) %></td>
			<td><%=el.getSum_price() %></td>
		</tr>
		<%}%>
	</table>

	<h1>구매하지 않은 고객 명단</h1>
	<table>
		<tr>
			<th>userId</th>
			<th>주소</th>
			<th>구매량</th>
		</tr>
		<%for(OrderDto4 el : list2){%>
		<tr>
			<td><%=el.getUserid() %></td>
			<td><%=el.getAddr() %></td>
			<td><%=el.getQuantity() %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>