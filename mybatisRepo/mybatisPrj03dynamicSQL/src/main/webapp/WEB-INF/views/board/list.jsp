<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 목록</h1>
	
	<form action="/app03/board/search" method="get">
		<input type="search" name="titleValue" placeholder="제목검색">
		<input type="search" name="contentValue" placeholder="내용검색">
		<input type="search" name="writerValue" placeholder="작성자검색">
		<input type="submit" value="검색">
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자번호</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ bvoList }" var="bvo">
				<tr>
					<td>${ bvo.no }</td>
					<td>${ bvo.title }</td>
					<td>${ bvo.content }</td>
					<td>${ bvo.writer }</td>
					<td>${ bvo.enrollDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>









