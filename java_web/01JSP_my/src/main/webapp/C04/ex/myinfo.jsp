<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	// public static boolean isConfirm; 	// 기본값 false
%>

<%
	/* request 내장 객체 사용 */
	/* DB 조회 여부 확인 */
	Boolean isConfirm = (request.getAttribute("isConfirm")!=null)?(Boolean)request.getAttribute("isConfirm"):null;
	
	if(isConfirm!=null&&isConfirm==true){
		;	// 현재 위치에서 내용 표시, null이 아닌 경우 처리
	}else{	// null인 경우 유효성 체크로 보내버림. 아래 문서가 뜨지 않음
		// dbUtils.jsp로 해당 내용 Forwarding
		request.setAttribute("url","/myinfo");	// DB 요청 처리 insert
		request.setAttribute("serviceNo",2);	// ServiceNo C=1 R=2 U=3 D=4
		request.getRequestDispatcher("./validationCheck.jsp").forward(request,response);
		return;
	}
	
%>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h1>MyInfo 확인(DB Utils's로부터 Forwarding 처리 된 화면)</h1>
	결과 : <%=request.getAttribute("myinfo-result") %>
</body>
</html>
