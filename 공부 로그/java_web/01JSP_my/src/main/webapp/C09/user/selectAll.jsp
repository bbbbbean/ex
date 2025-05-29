<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- DB import -->
<%@ page import="C09.DBUtils, C04.*, java.util.*" %>

<%
	DBUtils dbutils = DBUtils.getInstance();
	List<UserDto> list = dbutils.selectAllUser();

%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- selectAllUser를 이용해서 table의 해당 user정보 표시 -->
	<!--
		1. selectAllUser를 이용해서 table에 해당 user정보 표시
		2. 만들어진 테이블에 컬럼을 추가해서 해당 컬럼의 수정 버튼 만들기
		3. 만들어진 테이블에 컬럼을 추가해서 해당 컬럼의 삭제 버튼 만들기
		4. 수정 버튼을 클릭하면 수정 페이지로 이동 (update.jsp + 해당 사용자 파라미터 전달)
		5. 삭제 버튼을 클릭하면 삭제 페이지로 이동 (delete.jsp + 해당 사용자 파라미터 전달)
	
	-->
	총인원 : <%=list.size() %> <br />
	<table>
		<tr>
			<th>계정</th>
			<th>패스워드</th>
			<th>역할</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<%for(UserDto user:list){%>
		<tr>
			<td><%=user.getUserid() %></td>
			<td><%=user.getPassword() %></td>
			<td><%=user.getRole() %></td>
			<td>
				<a href="./update_form.jsp?userid=<%=user.getUserid()%>">수정하기</a>
			</td>
			<td>
				<%-- <a href="./delete.jsp?userid=<%=user.getUserid()%>">삭제하기</a> --%>
				<a href="javascript:deleteFunc('<%=user.getUserid()%>')">삭제하기</a>
				<button onclick="deleteFunc('<%=user.getUserid()%>')">삭제하기</button>
			</td>
		</tr>
		<% } %>
	</table>
	
	<script>
		// 경고창 띄우기용 스크립트
		
		function deleteFunc(userid){
			const isDelete = confirm("정말 삭제하시겠습니까?");
			if(isDelete)
				// `` - 보간법 적용이 잘 되지 않음 -> 인자를 잘 받아오지 못함 그냥 따로 쓰기
				// '' 안의 문자를 문자열 처리 -> 그냥 +로 이어주기
				location.href = './delete.jsp?userid='+userid;
		}
	
	</script>
</body>
</html>