<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>홈 페이지</h1>
	
	<c:if test="${ not empty loginMember }">
		<h2>${ loginMember.nick } 님 환영합니다.</h2>
		<a href="/app01/member/logout">로그아웃</a>
		<br>
		<a href="/app01/member/edit">마이페이지</a>
	</c:if>
	
	<c:if test="${ empty loginMember }">
	    <ul>
	        <li><a href="/app01/member/join">회원가입</a></li>
	        <li><a href="/app01/member/login">로그인</a></li>
	    </ul>
	</c:if>
	

</body>
</html>












