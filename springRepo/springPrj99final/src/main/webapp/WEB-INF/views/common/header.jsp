<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
                <form action="${root}/member/login" method="POST">
                    <input type="text" name="id" placeholder="아이디">
                    <br>
                    <input type="password" name="pwd" placeholder="비밀번호">
                    <br>
                    <input type="submit" value="로그인">
                </form>
                <button onclick="location.href='${root}/member/join'">회원가입</button>
            </div>
        </header>

        <nav>
            <a href="${root}/notice/list">공지사항</a>
            <a href="${root}/board/list">자유게시판</a>
            <a href="${root}/gallery/list">갤러리</a>
            <a href="${root}/member/edit">마이페이지</a>
        </nav>