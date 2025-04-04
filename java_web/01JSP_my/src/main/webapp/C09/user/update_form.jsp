<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C09.DBUtils,C04.*,java.util.*"%>
<%
	String userid = request.getParameter("userid");
	
	DBUtils dbutils = DBUtils.getInstance();
	UserDto user = dbutils.selectOneUser(userid);
	/* 위의 두 줄 한줄로 줄이는 법 */
	UserDto user_oneline = DBUtils.getInstance().selectOneUser(userid);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--
		1. dbUtils에서 selectOneUser(String userid)를 받아 단건 조회가 되도록 코드 생성
		2. selectOneUser함수를 이용해서 해당 사용자 정보 받아와서 form > input에 각각 표시
		3. dbUtils에서 updateUser(UserDto userDto)를 생성 -> Update 처리 코드
		4. update_form.jsp에서 수정 요청 버튼 클릭하면 ./update.jsp에서 업데이트 처리
		5. 처리 완료 이후 selectAll.jsp 이동
	-->

	<h1>User Update</h1>
	<table>
		<tr>
			<th>계정</th>
			<th>패스워드</th>
			<th>역할</th>
		</tr>
		<tr>
			<td><%=user.getUserid() %></td>
			<td><%=user.getPassword() %></td>
			<td><%=user.getRole() %></td>
		</tr>
	</table>
	<form action="./update.jsp">
		<label>계정</label>
		<!-- value로 넣으면 값이 미리 input란에 들어가 있음 -->
		<input type="text" name="userid" value="<%=user.getUserid() %>" readonly/> <br />
		<label>비밀번호</label>
		<input type="text" name="password" value="<%=user.getPassword() %>" /> <br />
		<label>역할</label>
		<input type="text" name="role" value="<%=user.getRole() %>" /> <br />
		<button>수정 요청</button>
		<a href="javascript:history.go(-1)">이전으로</a>
	</form>
	
</body>
</html>