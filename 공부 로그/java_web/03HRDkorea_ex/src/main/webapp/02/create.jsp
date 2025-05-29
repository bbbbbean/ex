<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Utils.*" %>

<!--
	파라미터 받기(액션 태그) : useBean = 객체 생성 가능?
	조건 : Dto, input name 이름 동일 / Dto 생성자, getter, setter 필수 생성
-->
<!-- id : 참조변수명, 걍 객체 이름 -->
<jsp:useBean id="classDto" class="Utils.ClassDto" scope="request"/>
<jsp:setProperty name="classDto" property="*" />
<%
	System.out.println(classDto);
	// db 연결 및 함수 실행
	int result = DBUtils.getInstance().insertClass(classDto);
 	if(result>0){
 		String code = "<script>";
 		code+="alert('수강신청이 정상적으로 완료되었습니다!');";
 		code+="location.href='../index.jsp'";
 		code+="</script>";
 		out.println(code);
	}else{
		out.println("<script>alert('수강신청에 실패했습니다.');location.href='./index.jsp'</script>");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>