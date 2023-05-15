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

    <div id="msg-area">

    </div>
	
	<script>

        const socket = new WebSocket("ws://127.0.0.1:8888/app/server");

        socket.onopen = function(){
            console.log("웹소켓 연결됨...");
        }
        socket.onclose = function(){
            console.log("웹소켓 끊김...");
        }
        socket.onerror = function(){
            console.log("웹소켓 연결 실패...");
        }
        socket.onmessage = function(e){
            const msgArea = document.querySelector("#msg-area");
            msgArea.innerHTML += e.data + "<br>";
        }



        function sendMsg(){
            const str = document.querySelector("input[name=msg]").value;
            socket.send(str);
        }

    </script>

</body>
</html>









