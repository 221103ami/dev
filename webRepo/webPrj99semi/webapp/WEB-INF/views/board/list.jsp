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
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="bvo">
						<tr>
							<td>${bvo.no}</td>
							<td>${bvo.title}</td>
							<td>${bvo.writer}</td>
							<td>${bvo.enrollDate}</td>
							<td>${bvo.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<c:if test="${ loginMember != null}">
				<div id="btn-wrap">
					<button onclick="location.href='/board/write'">게시글 작성</button>
				</div>
			</c:if>
			
			<div id="page-area">
			
				<c:if test="${ pageVo.currentPage > 1 }">
					<a href="/board/list?page=${pageVo.currentPage-1}">이전</a>
				</c:if>
				
				<c:forEach var="i" begin="${pageVo.startPage}" end="${pageVo.endPage}">					
					<c:if test="${pageVo.currentPage == i}">
						<span>${i}</span>
					</c:if>
					<c:if test="${pageVo.currentPage != i}">
						<a href="/board/list?page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				
				<c:if test="${ pageVo.currentPage < pageVo.maxPage }">
					<a href="/board/list?page=${pageVo.currentPage+1}">다음</a>
				</c:if>
			</div>

		</main>
	
	</div>

</body>
</html>


<script>

	const tbody = document.querySelector("main tbody");
	tbody.addEventListener("click" , function(event){
		const no = event.target.parentNode.children[0].innerText;
		location.href = "/board/detail?no=" + no;
	});

</script>







