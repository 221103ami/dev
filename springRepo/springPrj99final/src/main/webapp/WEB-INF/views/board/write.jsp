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
		/* display: none; */
	}


</style>

</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			
			<h1>게시글 작성하기</h1>

			<form action="${root}/board/write" method="POST">
				<div id="form-area">
					<label>제목</label>
					<input type="text" name="title" placeholder="제목을 입력하세요">
					<label>주제</label>
					<select name="categoryNo">
						<option>없음</option>
						<option value="10">자유</option>
						<option value="20">코딩</option>
						<option value="30">게임</option>
						<option value="40">운동</option>
						<option value="50">요리</option>
					</select>
					<label>내용</label>
					<textarea name="content"></textarea>
					<div>
						<label for="thumbnail-tag">사진</label>
						<input id="thumbnail-tag" type="file" name="f" multiple accept=".jpg,.png,.jpeg">
					</div>
					<div id="thumbnail-area"></div>
					<input type="submit" value="작성하기">
				</div>
			</form>
			
		</main>
	
	</div>

</body>
</html>


<script>
	//업로드 파일 미리보기

	//변수 준비
	const fileTag = document.querySelector('input[name="f"]');
	const thumbnailArea = document.querySelector('#thumbnail-area');

	//이벤트 핸들러 연결
	fileTag.addEventListener('change' , function(){
		thumbnailArea.innerHTML = '';		//썸네일 에리어 지우기

		//파일 있으면 미리보기 작업 진행
		if(fileTag.files.length > 0){
			for(let f of fileTag.files){
				const reader = new FileReader();
				reader.addEventListener("load" , processPreview);
				reader.readAsDataURL(f);
			}
		}
	});

	//이미지 요소 만들어서, 화면에 추가
	function processPreview(event){
		const imgTag = document.createElement('img');
		imgTag.setAttribute("src" , event.target.result);
		imgTag.setAttribute("width" , "100px");
		imgTag.setAttribute("height" , "100px");
		thumbnailArea.appendChild(imgTag);
	}

</script>

















