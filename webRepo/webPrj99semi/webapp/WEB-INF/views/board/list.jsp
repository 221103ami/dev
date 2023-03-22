<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/board/list.css">

</head>
<body>

	<div id="wrapper">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${boardList}" var="bvo">
						<tr>
							<td>${bvo.no}</td>
							<td>${bvo.title}</td>
							<td>${bvo.writer}</td>
							<td>${bvo.enrollDate}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>

			<div id="btn-wrap">
				<button onclick="location.href='/board/write'">게시글 작성</button>
			</div>
			<div id="page-area">
				<a href="">이전</a>
				<a href="">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href="">다음</a>
			</div>

		</main>
	
	</div>

</body>
</html>









