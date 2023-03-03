<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//데이터꺼내기
    	String memberId = request.getParameter("memberId");
    	String memberPwd = request.getParameter("memberPwd");
    	String memberNick = request.getParameter("memberNick");
    	
    	//비지니스
    	System.out.println(memberId);
    	System.out.println(memberPwd);
    	System.out.println(memberNick);
    	
    	//결과
    	if(memberId.equals("admin")){ %>
    		<h1>회원가입실패</h1>
    	<% }else{ %>
	    	<h1>회원가입성공</h1>
    	<% } %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	

</body>
</html>