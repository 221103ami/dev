<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String nick = (String)session.getAttribute("nick");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메인화면</h1>
	
	<h2><%= nick %> 님 환영합니다 ~</h2>
	
	<ol>
		<li><a href="/app20/member/join">회원가입</a></li>
		<li><a href="/app20/member/login">로그인</a></li>
		<li><a href="회원가입요청보낼경로">정보수정</a></li>
		<li><a href="회원가입요청보낼경로">삭제</a></li>
	</ol>

</body>
</html>

















    