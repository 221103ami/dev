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

    <form action="/app25/member/join" method="POST">
        <input type="text" name="memberId" placeholder="아이디">
        <input type="password" name="memberPwd" placeholder="패스워드">
        <input type="text" name="memberNick" placeholder="닉네임">
        <input type="submit" value="회원가입">
    </form>
    

</body>
</html>