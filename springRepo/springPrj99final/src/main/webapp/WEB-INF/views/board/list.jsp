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
		width:600px;
		margin: auto;
		display: flex;
		justify-content: center;
	}
	
	#page-area > a {
		margin: 15px;
	}

	.hide{
		display: none;
	}
	
	#search-area{
		width : 600px;
		margin: auto; 
	}
	
	#write-btn-area{
		width : 600px;
		margin : auto;
		display: flex;
		flex-direction: row-reverse;
	}

	tbody > tr:hover {
		background-color: darkgray;
		cursor: pointer;
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
					<input type="text" name="searchValue" value="${searchMap.searchValue}" placeholder="검색할값을 입력하세요">
					<select class="hide" name="searchValue">
						<c:forEach items="${cvoList}" var="cvo">
							<option value="${cvo.NO}">${cvo.NAME}</option>
						</c:forEach>
					</select>
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

			<c:if test="${not empty loginMember}">
				<div id="write-btn-area">
					<a class="btn btn-primary" href="${root}/board/write">작성하기</a>
				</div>
			</c:if>

			<div id="page-area">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/board/list?page=${pv.currentPage-1}&searchType=${searchMap.searchType}&searchValue=${searchMap.searchValue}" class="btn btn-secondary btn-sm">이전</a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
					<a href="${root}/board/list?page=${i}&searchType=${searchMap.searchType}&searchValue=${searchMap.searchValue}" class="btn btn-secondary btn-sm">${i}</a>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/board/list?page=${pv.currentPage+1}&searchType=${searchMap.searchType}&searchValue=${searchMap.searchValue}" class="btn btn-secondary btn-sm">다음</a>
				</c:if>
			</div>
		
		</main>
		
	</div>

</body>
</html>


<script>
	
	// 변수 준비
	const searchTypeTag = document.querySelector('select[name="searchType"]');
	const svInput = document.querySelector('input[name="searchValue"]');
	const svSelect = document.querySelector('select[name="searchValue"]');

	//서치타입 초기값 셋팅
	function initSearchType(){
		const optionTag = document.querySelector('option[value="${searchMap.searchType}"]');
		if(optionTag != null){
			optionTag.selected = true;
		}
	}
	
	//서치밸류 형태 변경
	function toggleSearchValueTag(){
		if(searchTypeTag.value != 'category'){
			showNotCategory();
		}else{
			showCategory();
		}
	}

	//서치밸류 형태1
	function showNotCategory(){
		//인풋 태그가 보이게
		svInput.classList.remove('hide');
		svInput.name = 'searchValue';
		svSelect.classList.add('hide');
		svSelect.name = 'xxx';
		
		svInput.value = '';
	}
	
	//서치밸류 형태2
	function showCategory(){
		//셀렉트 태그가 보이게
		svInput.classList.add('hide');
		svInput.name = 'xxx';
		svSelect.classList.remove('hide');
		svSelect.name = 'searchValue';
	}
	
	//서치밸류 형태 초기셋팅
	function initSearchValueType(){
		if('${searchMap.searchType}' == 'category'){
			showCategory();
		}else{
			showNotCategory();
		}
	}
	
	//서치밸류 selected 셋팅
	function initSearchValueSelected(){
		const optionTag = document.querySelector('option[value="${searchMap.searchValue}"]');
		if(optionTag != null){
			optionTag.selected = true;
		}
	}
	
	//input태그 (서치밸류) 값 초기셋팅
	function initSearchValueInput(){
		svInput.value = '${searchMap.searchValue}';
	}
	
	initSearchValueSelected();
	initSearchType();
	initSearchValueType();
	initSearchValueInput();
	
	//이벤트 리스너 //서치밸류 형태 변경하는 이벤트 등록
	searchTypeTag.addEventListener('change' , toggleSearchValueTag);
	
	
	//행 클릭했을 때 , 상세조회
	const tbody = document.querySelector('main > table > tbody');
	tbody.addEventListener("click" , (event)=>{
		const no = event.target.parentNode.children[0].innerText;
		location.href = '${root}/board/detail?no=' + no;
	});

	
	
</script>














