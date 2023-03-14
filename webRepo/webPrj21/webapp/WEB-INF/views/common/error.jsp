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
		String msg = (String)request.getAttribute("msg");
	%>

	<h1><%= msg %></h1>
	
	<a href="/app21">메인으로</a>

</body>
</html>










