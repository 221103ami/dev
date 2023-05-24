<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#gallery-area{
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		place-items: center center;
	}

</style>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
		
			<h1>갤러리 목록 조회</h1>
		
			<a class="btn btn-primary" href="${root}/gallery/write">작성하기</a>

			<hr>

			<div id="gallery-area">

				<div>
					<img 
						width="100" 
						height="100" 
						src="${root}/resources/upload/gallery/${voList[0].changeName}" 
						alt="${voList[0].originName}"
					>
					<span>${voList[0].title}</span>
				</div>

			</div>

			
		</main>
	
	</div>


</body>
</html>