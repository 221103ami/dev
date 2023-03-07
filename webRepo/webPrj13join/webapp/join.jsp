<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//데이터 꺼내기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//비지니스 로직
		System.out.println(id);
		System.out.println(pwd);
		
		//결과 응답
	%>
	
	<h1 style="color:red;">join success !!!</h1>
	

</body>
</html>





















