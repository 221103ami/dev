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

	#comment-area{
		width: 100%;
		border-left: 1px solid black;
		border-right: 1px solid black;
		display: grid;
		grid-template-columns: 5fr 1fr;
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
			
			<div id="comment-area">
				<input type="text" name="comment" placeholder="댓글을 입력하세요">
				<button onclick="writeComment();" class="btn btn-primary btn-sm">댓글작성</button>
				<div>댓글내용111</div>
				<div>댓글작성자</div>
			</div>
			
		</main>
	
	</div>

</body>
</html>

<script>

	const div = document.querySelector('#thumbnail-area');
	
	let imgTag;
	let aTag;
	<c:forEach items="${bvo.attList}" var="fvo">
		//a태그 만들기
		aTag = document.createElement('a');
		aTag.href = "${root}/board/att/down?ano=${fvo.no}";
		//이미지 요소 만들기
		imgTag = document.createElement('img');
		imgTag.setAttribute("src" , "${root}/${path}/${fvo.changeName}");
		imgTag.setAttribute("alt" , "${fvo.originName}");
		imgTag.setAttribute("width" , "100px");
		imgTag.setAttribute("height" , '100px');

		//a태그 내부에 img 추가
		aTag.appendChild(imgTag);

		//div 안에 a태그 추가
		div.appendChild(aTag);
	</c:forEach>



	function writeComment(){
		//ajax 이용해서 서버에 댓글내용 보내기
		const content = document.querySelector('input[name=comment]').value;
		
		$.ajax({
			url : '${root}/board/reply/write' ,
			type : 'POST' ,
			data : {
				'bno' : '${bvo.no}' ,
				'content' : content ,
			} , 
			success : function(data){
				if(data == 'ok'){
					alert("댓글 작성 완료 !");
				}else if(data == 'unauthor'){
					alert("로그인 후 작성 가능합니다.");
				}
				else{
					alert("댓글 작성 실패 ...");
				}
			} , 
			error : function(){
				alert('bad...');
			} ,
		});
	}

</script>














