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

	#comment-area , 
	#comment-header {
		width: 100%;
		border-left: 1px solid black;
		border-right: 1px solid black;
		display: grid;
		grid-template-columns: 4fr 1fr;
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
			
			<div id="comment-header">
				<input type="text" name="comment" placeholder="댓글을 입력하세요">
				<button onclick="writeComment();" class="btn btn-primary btn-sm">댓글작성</button>
			</div>
			<div id="comment-area">
				
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
		//로그인 안되어있으면 ㄴㄴ
		const writerNo = '${loginMember.no}';
		if(writerNo <= 0){
			alert("로그인 후 작성 가능합니다. (JS에서 검사)");
			return;
		}

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
					document.querySelector('input[name=comment]').value = '';
					loadReply();
				}else if(data == 'unauthor'){
					alert("로그인 후 작성 가능합니다.");
				}else{
					alert("댓글 작성 실패 ...");
				}
			} , 
			error : function(){
				alert('bad...');
			} ,
		});
	}
	


	//댓글 불러오기
	loadReply();

	function loadReply(){

		const commentArea = document.querySelector('#comment-area');
		commentArea.innerHTML = '';
		const writerNo = '${loginMember.no}';

		$.ajax({
			url : '${root}/board/reply/list' ,
			type  : 'get' ,
			data : {
				'bno' : '${bvo.no}'	
			} ,
			dataType : 'json' ,
			success : function(data){
				console.log(data);

				for(let replyVo of data){
					let str = "";
					str += "<div>";
					str += replyVo.content;
					str += "</div>";
					str += "<div>";
					str += "<span>"
					str += replyVo.writerNick;
					str += "</span>"
					if(writerNo == replyVo.writerNo || writerNo == 1 ){
						str += "<button class='btn btn-warning btn-sm' onclick='editReply(" + replyVo.no + ");'>수정</button>";
						str += "<button class='btn btn-danger btn-sm' onclick='deleteReply(" + replyVo.no + ");'>삭제</button>";
					}
					str += "</div>";
					commentArea.innerHTML += str;
				}

			} ,
			error : function(error){
				console.log(error);
			} ,
		});

	}

	
	//댓글 삭제 함수
	function deleteReply(rno){
		
		const result = confirm("삭제 진짜로 ???");
		if(!result){
			return;
		}

		$.ajax({
			url : '${root}/board/reply/delete?rno=' + rno ,
			type : 'delete' ,
			// data : {
			// 	'rno' : rno
			// } ,
			success : function(data){
				console.log(data);
				alert("삭제 완료 !");
				loadReply();
			} ,
			error : function(error){
				console.log(error);
				alert("삭제 실패 ...");
			} ,
		});

	}

	//댓글 수정 함수
	function editReply(rno){
		//댓글번호 , 수정할내용
		const newContent = window.prompt("수정할 내용을 입력하세요");

		//수정 요청 보내기
		$.ajax({
			url : '${root}/board/reply/edit' , 
			type : 'post' , 
			data : {
				content : newContent ,
				no : rno ,
			} , 
			success : function(data){
				alert("수정 완료 !");
				loadReply();
			} , 
			error : function(error){
				alert("수정 실패 ...");
			} , 
		});

	}


</script>














