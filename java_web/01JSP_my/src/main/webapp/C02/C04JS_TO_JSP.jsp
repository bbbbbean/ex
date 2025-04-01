<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 파일 하나인 경우 java 작업물을 jsp로 변환할 때 -->
	<!-- form이 필요(앞선 작업물들 보면 form과 process 한쌍) - 하단에 form작성 -->
	<!-- 역행하는 방식, 단일타입이라 이럼.. 흐름 구조 파악용 -->
	<!-- *** 비동기 처리 : xhr, jquery ajax, fetch, promise, axios *** -->
	<%!
		boolean isInit=true;
	%>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String flag = request.getParameter("flag");
		System.out.println("FLAG : " + flag);
		System.out.println("isInit = " + isInit);
		if(flag!=null && flag.equals("true")){
			isInit=false;
		}
			
	%>
	USERNAME : <%=username%><br>
	PASSWORD : <%=password%><br>
	ROLE : <%=role%><br>
	
	<!-- 자기 자신에게 던짐 -->
	<form action="C04JS_TO_JSP.jsp" name="myForm">
		<input name="username" type="hidden" /> 
		<input name="password" type="hidden" /> <input name="role" type="hidden" /> 
		<!-- 최초 접속인지 판단 -->
		<!-- 최초 접속 시 form 위쪽은 무시해야함 -> 처음엔 form작업 후 백엔드 작업을 해야함 -->
		<input name="flag" value="true" type="hidden" />
	</form>

	<script>
		const form = document.myForm;	// 폼 찾기
		const flag = '<%=isInit%>';		// 두번째 요청인지, 처음 요청하는건지 판별
		console.log("flag",flag);		
		if(flag == 'true'){				// 처음 실행시 해당 구문 실행
			form.username.value = "홍길동";
			form.password.value = "1234";
			form.role.value = "ROLE_USER";
			form.submit();
		}
	</script>
</body>
</html>