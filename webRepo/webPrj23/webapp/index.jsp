<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${alertMsg != null}">
		<script>
			alert('${alertMsg}');
		</script>
	</c:if>
	
	<c:remove var="alertMsg" scope="session"/>

	<h1>메인화면</h1>

	<c:if test="${loginMember != null}">
		<h3>${loginMember.nick} 님 환영합니다</h3>
		<a href="/app23/member/logout">로그아웃</a>
	</c:if>
	
	<ul>
		<li><a href="/app23/member/join">회원가입</a></li>
		<li><a href="/app23/member/login">로그인</a></li>
		<li><a href="/app23/member/edit">마이페이지</a></li>
		<li><a href="/app23/member/quit">탈퇴</a></li>
	</ul>
	
</body>
</html>








