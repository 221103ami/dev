<%@ page import="com.kh.app.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String alertMsg = (String)session.getAttribute("alertMsg");
    	session.removeAttribute("alertMsg");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	if(alertMsg != null){%>
		<script>
			alert("<%= alertMsg %>");
		</script>
	<%}
%>


</head>
<body>

	<h1>원용이의 홈페이지</h1>
	
	<%
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	
		if(loginMember != null){%>
			<h3><%= loginMember.getNick() %> 님 환영합니다.</h3>
			<a href="/app22/member/logout">로그아웃</a>
		<%}
	%>
	
    <ol>
        <li><a href="/app22/member/join">회원가입</a></li>
        <li><a href="/app22/member/login">로그인</a></li>
        <li><a href="/app22/member/edit">정보수정</a></li>
        <li><a href="/app22/member/quit">회원탈퇴</a></li>
    </ol>

</body>
</html>