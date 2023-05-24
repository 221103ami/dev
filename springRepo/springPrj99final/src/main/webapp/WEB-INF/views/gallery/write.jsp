<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			
			<h1>갤러리 작성</h1>
			
			<form action="${root}/gallery/write" method="POST" enctype="multipart/form-data">
				
				<input type="text" name="title">
				<br />
				<textarea name="content"></textarea>
				<br />
				<input type="file" name="f">
				<br />
				<input type="submit" value="작성하기">
				
			</form>
			
		</main>
	
	</div>

</body>
</html>



















