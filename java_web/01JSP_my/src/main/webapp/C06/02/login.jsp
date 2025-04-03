<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 로그인 처리만 할 예정 : 보여주는 형식 필요 없음 -->
<!-- 로그인 처리 후 main 페이지로 redirect 예정 -->

<%
	// 파라미터 받아오기
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	// 파라미터 유효성 체크
	if(username.isEmpty()){
		/* 하나의 라인으로 처리 */
		/* 알림창으로 띄움 -> 익숙한 형태는 아님, 로그인창에 바로 뜨는 아는 형태로 수정 */
		// out.println("<script>alert('username을 입력하세요');location.href='./login_form.jsp'</script>");
		request.setAttribute("username_msg","username을 입력하세요");
	}
	if(password.isEmpty()){
		request.setAttribute("password_msg","password을 입력하세요");
	}
	if(username.isEmpty()||password.isEmpty()){
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return;
	}
	
	// 01 ID 확인 (식별, DB 조회-생략)
	if(!username.equals("admin")){
		request.setAttribute("username_msg","해당 ID는 존재하지 않습니다.");
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return;
	}
	// 02 PW 확인 (인증, 일치여부 확인)
	if(!password.equals("1234")){
		request.setAttribute("password_msg","패스워드가 일치하지 않습니다.");
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return;
	}
	
	// 03 사용자 상태 정보(인증됨)를 session 저장
	session.setAttribute("isAuth", true);
	session.setAttribute("role", "ROLE_ADMIN");
	session.setMaxInactiveInterval(10);	// 10초 동안 세션(로그인상태) 유지 (기본 1800초 : 30분)
	
	// 04 로그인 처리 후 main page redirect
	out.println("<script> alert('로그인 성공! MAIN page로 이동합니다.');location.href='main.jsp'</script>");




%>