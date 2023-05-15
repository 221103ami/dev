package com.kh.app;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
 * afterConnectionEstablished
 * handleTextMessage
 * afterConnectionClosed
 */

@Slf4j
//public class ChatSocketServer implements WebSocketHandler {
public class ChatSocketServer extends TextWebSocketHandler {
	
	//모든세션의정보를담을객체
	private final Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Object nick = session.getAttributes().get("nick");
		log.info("{} 연결됨" , nick);
		sessionSet.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		Map<String, Object> attrMap = session.getAttributes();
		String sender = (String)attrMap.get("nick");
		String msg = message.getPayload();
		TextMessage textMsg = new TextMessage(sender + " : " + msg);
		broadCast(textMsg);
	}
	
	private void broadCast(TextMessage textMsg) throws IOException {
		for(WebSocketSession session : sessionSet) {
			session.sendMessage(textMsg);
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Object nick = session.getAttributes().get("nick");
		log.info("{} 연결끊김" , nick);
		sessionSet.remove(session);
	}
	
		

}







