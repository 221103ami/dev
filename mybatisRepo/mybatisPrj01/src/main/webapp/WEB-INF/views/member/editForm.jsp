<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>수정하기</h1>

    <form action="/app01/member/edit" method="post">
        <input type="text" name="memberId" placeholder="아이디" value="${loginMember.id}">
        <br>
        <input type="password" name="memberPwd" placeholder="비밀번호">
        <br>
        <input type="text" name="memberNick" placeholder="닉네임" value="${loginMember.nick}">
        <br>
        <input type="submit" value="수정하기">
    </form>
    
    <a href="/app01/member/quit">탈퇴하기</a>

</body>
</html>













