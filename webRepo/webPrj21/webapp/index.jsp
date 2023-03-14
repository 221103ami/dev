<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: none;
	}
</style>
<script>

	<%
		String alertMsg = (String)session.getAttribute("alertMsg");
		session.removeAttribute("alertMsg");
		
		if(alertMsg != null){%>
			alert('<%= alertMsg %>');
		<%}
	%>

	
	
</script>
</head>
<body>

	<h1>메인페이지</h1>
	
	<%
		String x = (String)session.getAttribute("nick");
	
		if(x != null){%>
			<h3><%= x %> 님 환영합니다.</h3>
			<!-- <a href="/app21/member/logout">로그아웃</a> -->
			<button onclick="location.href = '/app21/member/logout'">로그아웃</button>
		<%}else{%>
			<h3> 로그인을 해주세요 ~ </h3>
		<%}
	%>
	
	<ol>
		<li><a href="/app21/member/join">회원가입</a></li>
		<li><a href="/app21/member/login">로그인</a></li>
		<li><a href="~~~">비번변경</a></li>
		<li><a href="~~~">탈퇴</a></li>
	</ol>

</body>
</html>