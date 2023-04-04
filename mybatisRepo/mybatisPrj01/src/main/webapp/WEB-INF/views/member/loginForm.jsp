<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>로그인</h1>

    <form action="/app01/member/login" method="post">
        <input type="text" name="memberId" placeholder="아이디">
        <br>
        <input type="password" name="memberPwd" placeholder="비밀번호">
        <br>
        <input type="submit" value="로그인">
    </form>

</body>
</html>