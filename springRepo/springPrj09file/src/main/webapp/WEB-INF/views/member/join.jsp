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
	
	<form action="/app/member/join" method="post" enctype="multipart/form-data">
		<input type="text" name="memberId">
		<br>
		<input type="password" name="memberPwd">
		<br>
		<input type="text" name="memberNick">
		<br>
		<input type="file" multiple accept=".png,.jpg,.jpeg" name="memberProfile">
		<br>
		<input type="submit" value="가입하기">
	</form>

</body>
</html>





