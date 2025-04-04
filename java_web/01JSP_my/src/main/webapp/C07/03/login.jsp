<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 로그인 처리만 할 예정 : 보여주는 형식 필요 없음 -->
<!-- 로그인 처리 후 main 페이지로 redirect 예정 -->

<%
	// 파라미터 받아오기
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	// 아래 두 항목은 선택 사항 -> 유효성 검사할 필요 없음
	String idSave = request.getParameter("idSave");
	String pwSave = request.getParameter("pwSave");
	// on, null 형태로 나옴
	System.out.println("idSave : "+idSave);
	System.out.println("pwSave : "+pwSave);
	
	// 파라미터 유효성 체크 : 반드시 지켜야 할 것
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
	session.setMaxInactiveInterval(60);	// 60초 동안 세션(로그인상태) 유지 (기본 1800초 : 30분)
	
	// 03+a 쿠키 설정!
	// 쿠키 밖으로 빼고 정리해보기!
	if(idSave!=null){	// on값이 들어오면
		// response에 실어 보내기
		Cookie cookie = new Cookie("username",username);
		cookie.setMaxAge(60*5);
		// 로그인 폼에서만 쿠키 확인 가능 -> 이걸 이제 id입력창에 넣으면 됨 -> login_form에서 작업
		cookie.setPath("/01JSP_my/C07/03/login_form.jsp");	// 경로는 /01JSP_my/C07/02/getCookie.jsp 처럼 정확하게 -> 프로젝트 이름 다 나오는거 좋지 않음
		response.addCookie(cookie);
		
		Cookie idchk = new Cookie("idchk","checked");
		idchk.setMaxAge(60*5);
		idchk.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(idchk);
	}else{
		// 쿠키 삭제 작업
		// 체크 해제 시 아이디 정보가 사라지게
		Cookie cookie = new Cookie("username",null);
		cookie.setMaxAge(0);	// 쿠키 만료
		cookie.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(cookie);
		
		Cookie idchk = new Cookie("idchk",null);
		idchk.setMaxAge(0);
		idchk.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(idchk);
	}
	
	if(pwSave!=null){	// on값이 들어오면
		// response에 실어 보내기
		Cookie cookie = new Cookie("password",password);
		cookie.setMaxAge(60*5);
		// 로그인 폼에서만 쿠키 확인 가능 -> 이걸 이제 id입력창에 넣으면 됨 -> login_form에서 작업
		cookie.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(cookie);
		
		Cookie pwchk = new Cookie("pwchk","checked");
		pwchk.setMaxAge(60*5);
		pwchk.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(pwchk);
	}else{
		// 쿠키 삭제 작업
		// 체크 해제 시 아이디 정보가 사라지게
		Cookie cookie = new Cookie("password",null);
		cookie.setMaxAge(0);	// 쿠키 만료
		cookie.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(cookie);
		
		Cookie pwchk = new Cookie("pwchk",null);
		pwchk.setMaxAge(0);
		pwchk.setPath("/01JSP_my/C07/03/login_form.jsp");
		response.addCookie(pwchk);
	}
	
	
	// 04 로그인 처리 후 main page redirect
	out.println("<script> alert('로그인 성공! MAIN page로 이동합니다.');location.href='main.jsp'</script>");




%>