<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int x = 1 / 0;
	%>

	<h1>인덱스</h1>
	
	<jsp:include page="/test.jsp"></jsp:include>

</body>
</html>





