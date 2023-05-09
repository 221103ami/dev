<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>결과화면 ~~~</h1>
	
	${ data.response.header }
	
	<hr>
	
	${ data.response.body.items.item[0] }
	<br>
	${ data.response.body.items.item[1] }
	<br>
	${ data.response.body.items.item[2] }
	<br>
	
</body>
</html>













