<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>회원가입</h1>

    <form action="/app01/member/join" method="post">
        <input type="text" name="memberId" placeholder="아이디">
        <br>
        <input type="password" name="memberPwd" placeholder="비밀번호">
        <br>
        <input type="text" name="memberNick" placeholder="닉네임">
        <br>
        <input type="submit" value="회원가입">
    </form>

</body>
</html>