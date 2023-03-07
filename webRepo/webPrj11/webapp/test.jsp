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
		System.out.println("JSP호출됨 ~~~");
	
		//클라이언트가 보낸 데이터 확인
		String num = request.getParameter("num");
		System.out.println(num);
	%>
	<h1 style="background-color:red;">world ~~~</h1>

</body>
</html>























