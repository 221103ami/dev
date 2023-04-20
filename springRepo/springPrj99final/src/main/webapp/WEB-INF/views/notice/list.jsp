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

	main table > tbody > tr:hover {
		background-color: lightgray;
		cursor: pointer;
	}
	
	#page-area{
		width:300px;
		margin : auto;
		margin-top : 30px;
		display : flex;
		justify-content: space-evenly;
	}

</style>
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1 align="center">공지사항 목록</h1>
			
			<c:if test="${loginMember.id == 'ADMIN'}">
				<div id="write-btn-area">
					<a id="write-btn" class="btn btn-primary" href="${root}/notice/write">글쓰기</a>
				</div>
			</c:if>

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
			
			<div id="page-area">
				<c:if test="${pv.currentPage > 1}">
					<a class="btn btn-primary btn-sm" href="${root}/notice/list?page=${pv.currentPage-1}">이전</a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
					<c:if test="${pv.currentPage != i}">
						<a class="btn btn-primary btn-sm" href="${root}/notice/list?page=${i}">${i}</a>
					</c:if>
					<c:if test="${pv.currentPage == i}">
						<a class="btn btn-secondary btn-sm">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a class="btn btn-primary btn-sm" href="${root}/notice/list?page=${pv.currentPage+1}">다음</a>
				</c:if>
			</div>

		</main>
		
	</div>

</body>
</html>

<link rel="stylesheet" href="${root}/resources/css/notice/list.css">

<script>

	const table = document.querySelector("main table tbody");
	table.addEventListener("click" , function(event){
		const num = event.target.parentNode.children[0].innerText;
		location.href = '${root}/notice/detail?num=' + num;
	});

</script>




