<%@page import="com.kh.app.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>정보 수정</h1>
	
	<form action="/app22/member/edit" method="POST">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" readonly value="<%= loginMember.getId() %>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPwd"> </td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="memberNick" value="<%= loginMember.getNick() %>"></td>
			</tr>
			<tr>
				<td colspan="2"><input style="width:100%;" type="submit" value="수정하기"></td>
			</tr>
		</table>
	</form>

</body>
</html>















