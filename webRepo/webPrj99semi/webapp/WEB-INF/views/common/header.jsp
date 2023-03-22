<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:if test="${alertMsg != null}">
	<script>
		alert('${alertMsg}');
	</script>
</c:if>

<c:remove var="alertMsg"/>
    
<link rel="stylesheet" href="/resources/css/header.css">
    
<header>

    <div id="header-top">

        <div></div>
        <div>
            <img width="100%" height="150px" src="/resources/zzz.PNG" alt="로고이미지">
        </div>
        <div>
        
        	<c:if test="${loginMember == null}">
             <form action="/member/login" method="post">
                 <input type="text" name="memberId" placeholder="아이디">
                 <input type="password" name="memberPwd" placeholder="패스워드">
                 <input type="submit" value="로그인">
             </form>
             <button onclick=" location.href = '/member/join'; ">회원가입</button>
        	</c:if>
        	
        	<c:if test="${loginMember != null}">
        		${loginMember.nick} 님 환영합니다.
        		<br>
        		<a href="/member/logout">로그아웃</a>
        	</c:if>
            
        </div>
    </div>

    <nav>
        <div><a href="/board/list">자유게시판</a></div>
        <div>갤러리</div>
        <div>공지사항</div>
    </nav>

</header>











