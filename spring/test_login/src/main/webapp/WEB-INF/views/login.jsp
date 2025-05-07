<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css">

	<title>Home</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/login" name="login" method="post" submit="false">
        <div class="login-continer">
            <div class="login-tit">
                <span>회원 로그인</span>
            </div>
            <div class="login-id">
                <input type="text" id="userid" name="userid" placeholder="아이디" >
            </div>
            <div class="login-pw">
                <input type="password" id="pwd" name="password" placeholder="비밀번호">
            </div>
            <div class="login-check">
                <input type="checkbox" id="remember-check" name="remember-me"> <span>아이디 저장하기</span>
            </div>
            <div class="login-btn">
                <a onclick="document.forms['login'].submit();">
                    <span>로그인</span>
                </a>
            </div>
            <div class="login-menu">
                <a href="${pageContext.request.contextPath }/join">
                    <span>회원가입</span>
                </a>
                <span>|</span>
                <a href="javascript:void(0)">
                    <span>아이디찾기</span>
                </a>
                <span>|</span>
                <a href="javascript:void(0)">
                    <span>비밀번호찾기</span>
                </a>
            </div>
        </div>
    </form>
</body>
</html>
