<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

	<h1>메인화면</h1>
	
	<button onclick="f01();">요청보내기</button>
	
	<script>
	
		function f01(){
			//요청을 보내는 JS 코드
			$.ajax({
				url : '/app/test' ,
				method : 'POST' ,
				data : {
					'atk' : '777',
					'def' : '333',
				} ,
				success : function(data){
					alert('통신 성공 !!');
					const mvo = JSON.parse(data);
					console.log(mvo);
				} ,
				error : function(){
					alert('통신 실패 ..');
				} ,
			});
		}
	
	</script>
	
	

</body>
</html>




















