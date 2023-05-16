package com.kh.app;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

@Component
public class ChatServer extends TextWebSocketHandler {

	//연결됨
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결됨 ~");
	}

	//연결끊김
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 끊김 ...");
	}
	
	//메세지 수신
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("수신 ~");
		System.out.println(message);
		
		MsgVo vo = new MsgVo();
		vo.setMsg("안녕ㅎㅎ");
		vo.setName("김스프링");
		vo.setTime("점심시간");
		
		Gson gson = new Gson();
		String str = gson.toJson(vo);
		
		session.sendMessage(new TextMessage(str));
	}
	

}











