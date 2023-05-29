<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>

		.view-area , .form-area {
			display: none;
		}

		.active{
			display: block;
		}

	</style>

</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>

			<div class="view-area active">
				<h1>갤러리 상세조회</h1>
				
				<div>${vo.title}</div>
				<img src="${root}/resources/upload/gallery/${vo.changeName}">
				<div>${vo.content }</div>
				
				<hr>
				
				<c:if test="${ loginMember.no eq vo.writerNo }">
					<a class="btn btn-warning" href="javascript:changeView();">수정</a>
					<a class="btn btn-danger" href="${root}/gallery/del/${vo.no}/${vo.changeName}">삭제</a>
				</c:if>
			</div>

			<div class="form-area">
				<form action="${root}/gallery/edit" method="post" enctype="multipart/form-data">

					<input type="hidden" name="no" value="${vo.no}">
					<br />
					<input type="text" name="title" value="${vo.title}">
					<br />
					<textarea name="content">${vo.content}</textarea>
					<br />
					<div>기존 파일명 : ${vo.originName}</div>
					<br />
					수정할 파일 (수정안할거면 그냥 두셔도 됩니다.) : <input type="file" name="f">
					<br />
					<input type="submit" value="수정하기">
				</form>
			</div>

			
		</main>
		
	</div>

	<script>

		function changeView(){
			//viewArea 액티브 클래스 제거
			const viewArea = document.querySelector('.view-area');
			viewArea.classList.remove('active');
			
			//formArea 액티브 클래스 추가
			const formArea = document.querySelector('.form-area');
			formArea.classList.add('active');
		}

	</script>

</body>
</html>


















