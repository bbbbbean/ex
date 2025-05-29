<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="css/signup.css">
	<title>Home</title>
</head>
<body>
    <section class="login-section">
        <img src="image/로고.png" alt="logo">
        <h2>임시 회원가입 페이지입니다.<br>사용하고 있는 비밀번호를 입력하지마세요.</h2>
        <form id="login-form" action="/join" method="post" name="join" submit="false">
            <label>
                <input id="nickname" type="text" name="userid" placeholder="아이디">
            </label>
            <label>
                <input type="password" id="pwd" name="password" placeholder="비밀번호">
            </label>
            <label>
                <input type="text" id="name" name="name" placeholder="이름">
            </label>
            <label>
                <input id="nickname" type="text" name="nickname" placeholder="사용자 닉네임">
            </label>
            <button class="document.forms['join'].submit();" style="background-color : #6EC3FF; ">회원가입</button>
        </form>

    </section>
    <section class="no-account-section">
        <span>계정이 있으신가요?</span>
        <a href="/login">로그인</a>
    </section>
</body>
</html>
