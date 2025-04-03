<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* 로그인이 되어있는데 세션이 유지되는 동안 해당 페이지로 온다면 메인페이지로 날리기 */
	if(session.getAttribute("isAuth")!=null){
		out.println("<script> alert('이미 로그인 된 상태입니다.');location.href='main.jsp' </script>");	
		// response.sendRedirect("./main.jsp"); // 해당이 들어가면 바로 재요청 들어가는 것 : 이떄까지 정보 사라짐. alert 요청 정보도 사라짐, 위 스크립트에서 위치잡아서 보내주기
	}
%>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	label{font-size:.9rem;}
	span{font-size:.7rem; color:red;}

</style>
</head>
<body>
	
	<h1>Login Form</h1>
	<div style="min-height:25px; font-size:.8rem; color:orange;">
		${param.message}	
	</div>
	<form action="${pageContext.request.contextPath}/C06/02/login.jsp" method="post">
		<div>
			<label for="">아이디 </label><span><!-- 메시지 입력란 -->${username_msg}</span> <br />
			<input type="text" name="username" />
		</div>
		<div>
			<label for="">패스워드 </label><span>${password_msg}</span> <br />
			<input type="text" name="password" />
		</div>
		<button>로그인</button>	
	</form>



</body>
</html>