<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 상단에 위치한 이 부분이 먼저 처리됨 -->

<% // 지시자
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.println("행 열 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.printf("행 : %d, 열 : %d\n",row,col);
	// 콘솔에 스캐너 입력값 입력하기 전까지 브라우저는 계속 로딩 상태
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 행, 열 입력해 테이블 만들기 -->
	<table>
		<tbody>
		<!-- <% %> 조각낼 수 있음 -->
			<%
				// tr 태그 생성 반복
				for(int i=0;i<row;i++){ %>
					<tr>
						<% for(int j=0;j<col;j++){%>
							<td><%=i+" : "+j %></td>
						<% }%>
					</tr>
				<%}
			%>
		</tbody>
	</table>
</body>
</html>