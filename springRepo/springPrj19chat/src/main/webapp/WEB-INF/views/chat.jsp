<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>채팅</h1>
	
	<input type="text" name="msg">
	<button onclick="sendMsg();">전송</button>
	
	<script>
		const socket = new WebSocket("ws://127.0.0.1:8888/app/server");

		socket.onopen = connectOk;
		socket.onerror = connectFail;
		socket.onclose = disconnect;
		socket.onmessage = rcvMsg;


		//웹소켓 연결 성공
		function connectOk(){
			console.log('연결 성공 ~');
		}
		//웹소켓 연결 실패
		function connectFail(){
			console.log('연결 실패 ㅠㅠ');
		}
		//웹소켓 끊김
		function disconnect(){
			console.log('연결 끊김 ...');
		}
	
		//메세지 수신
		function rcvMsg(event){
			console.log('메세지 수신');
			const x = JSON.parse(event.data);
			console.log("발신자 : " + x.name);
			console.log("메세지 : " + x.msg);
			console.log("전송시각 : " + x.time);
			
		}
		
		//메세지 발신
		function sendMsg(){
			const msg = document.querySelector("input[name=msg]").value;
			socket.send(msg);
		}
	
	</script>

</body>
</html>









