<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  	java.util.Scanner sc = new java.util.Scanner(System.in);
  	System.out.print("출력할 단수를 입력하세요");
  	int dan = sc.nextInt();
  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 단수 입력받아 해당 구구단을 찍어보세요 (Table로 만드세요) -->
	<table>
		<tbody>
			<tr>
			<% for(int i=1;i<=9;i++){%>
				<td><%=dan+"x"+i+"="+dan*i %></td>
			<%}%>
			</tr>
		</tbody>
	</table>
	
</body>
</html>