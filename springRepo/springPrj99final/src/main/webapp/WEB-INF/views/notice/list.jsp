<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#write-btn-area {
		width:600px;
		margin : auto;
		display : flex;
		flex-direction: row-reverse;
	}
</style>
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1 align="center">공지사항 목록</h1>
			
			<div id="write-btn-area">
				<a id="write-btn" class="btn btn-primary" href="${root}/notice/write">글쓰기</a>
			</div>

			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일시</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${nvoList}" var="nvo">
						<tr>
							<td>${nvo.no}</td>
							<td>${nvo.title}</td>
							<td>${nvo.enrollDate}</td>
							<td>${nvo.hit}</td>
						</tr>
					</c:forEach>
				
				</tbody>
			</table>

		</main>
		
	</div>

</body>
</html>

<link rel="stylesheet" href="${root}/resources/css/notice/list.css">





