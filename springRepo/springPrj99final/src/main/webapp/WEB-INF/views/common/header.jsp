<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- 부트스트랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    
    <c:set var="root" value="${pageContext.request.contextPath}" scope="page" />

    <link rel="stylesheet" href="${root}/resources/css/common/header.css">
    
    <c:if test="${ not empty alertMsg }">
	    <script>
	    	alert('${sessionScope.alertMsg}');
	    </script>
    </c:if>
    
    <c:remove var="alertMsg" scope="session"/>
    
    
	<header>
            <div></div>
            <div id="logo-area">
            	<a href="${root}/home">
	                <img width="400px" height="150px" src="${root}/resources/img/logo.PNG" alt="로고이미지">
            	</a>
            </div>
            <div id="member-area">
            	<c:if test="${ empty loginMember }">
	                <form action="${root}/member/login" method="POST">
	                    <input type="text" name="id" placeholder="아이디">
	                    <br>
	                    <input type="password" name="pwd" placeholder="비밀번호">
	                    <br>
	                    <input type="submit" value="로그인">
	                </form>
	                <button onclick="location.href='${root}/member/join'">회원가입</button>
            	</c:if>
            	<c:if test="${ not empty loginMember }">
            		${ loginMember.nick } 님 환영합니다. ~^^
            		<br>
            		<a href="${root}/member/logout">로그아웃</a>
            	</c:if>
            </div>
        </header>

        <nav>
            <a href="${root}/notice/list">공지사항</a>
            <a href="${root}/board/list">자유게시판</a>
            <a href="${root}/gallery/list">갤러리</a>
            <a href="${root}/member/edit">마이페이지</a>
        </nav>