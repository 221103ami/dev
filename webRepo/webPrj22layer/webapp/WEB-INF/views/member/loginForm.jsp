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
	
	<form action="/app22/member/login" method="POST">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPwd"> </td>
			</tr>
			<tr>
				<td colspan="2"><input style="width:100%;" type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>

</body>
</html>






