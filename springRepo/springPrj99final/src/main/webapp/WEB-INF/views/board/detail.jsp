<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	#form-area{
		width: 100%;
		height: 600px;
		background-color: gray;
		color: white;
		display: grid;
		grid-template-columns: 1fr 5fr 1fr 2fr;
		grid-template-rows: 1fr 5fr 3fr 1fr;
	}

	#form-area > textarea {
		grid-column: span 3;
	}

	#thumbnail-area{
		grid-column: span 3;
	}

	#form-area > input[type="submit"] {
		grid-column: span 4;
	}

	#thumbnail-tag{
		display: none;
	}


</style>

</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			
			<h1>게시글 상세조회</h1>

			<form action="${root}/board/write" method="POST">
				<div id="form-area">
					<label>제목</label>
					<input type="text" value="${bvo.title}" name="title" placeholder="제목을 입력하세요">
					<label>주제</label>
					<span>${bvo.categoryName}</span>
					<label>내용</label>
					<textarea name="content">
						${bvo.content}
					</textarea>
					<div>
						<label for="thumbnail-tag">사진</label>
						<input id="thumbnail-tag" type="file" name="f" multiple accept=".jpg,.png,.jpeg">
					</div>
					<div id="thumbnail-area">
					
					</div>
				</div>
			</form>
			
		</main>
	
	</div>

</body>
</html>

<script>

	const div = document.querySelector('#thumbnail-area');
	
	let imgTag;
	<c:forEach items="${bvo.attList}" var="fvo">
		//이미지 요소 만들기
		imgTag = document.createElement('img');
		imgTag.setAttribute("src" , "${root}/${path}/${fvo.changeName}");
		imgTag.setAttribute("alt" , "${fvo.originName}");
		imgTag.setAttribute("width" , "100px");
		imgTag.setAttribute("height" , '100px');
		//이미지 요소를 div 안에 추가하기
		div.appendChild(imgTag);
	</c:forEach>

</script>














