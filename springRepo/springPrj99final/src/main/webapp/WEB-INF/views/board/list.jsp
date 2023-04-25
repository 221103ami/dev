<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	main {
		background-color: black;
		color:white;
		height: 600px;
	}

	main h1{
		margin-top: 30px;
		margin-bottom: 30px;
	}

	main table {
		width: 600px;
		margin: auto;
	}

	main table td ,
	main table th {
		border: 1px solid white;
		box-sizing: border-box;
		text-align: center;
	}
	
	#page-area{
		width:300px;
		margin: auto;
		display: flex;
		justify-content: center;
	}
	
	#page-area > a {
		margin: 15px;
	}
</style>
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
		
			<h1 align="center">게시글 목록</h1>
			
			<form action="${root}/board/list" method="get">
				<div id="search-area">
					<select name="searchType">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="category">카테고리</option>
					</select>
					<input type="text" name="searchValue" placeholder="검색할값을 입력하세요">
					<input type="submit" value="검색하기">
				</div>
			</form>

			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>카테고리</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bvoList}" var="bvo">
						<tr>
							<td>${bvo.no}</td>
							<td>${bvo.title}</td>
							<td>${bvo.writerName}</td>
							<td>${bvo.categoryName}</td>
							<td>${bvo.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div id="page-area">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/board/list?page=${pv.currentPage-1}" class="btn btn-secondary btn-sm">이전</a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
					<a href="${root}/board/list?page=${i}" class="btn btn-secondary btn-sm">${i}</a>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/board/list?page=${pv.currentPage+1}" class="btn btn-secondary btn-sm">다음</a>
				</c:if>
			</div>
		
		</main>
		
	</div>

</body>
</html>









