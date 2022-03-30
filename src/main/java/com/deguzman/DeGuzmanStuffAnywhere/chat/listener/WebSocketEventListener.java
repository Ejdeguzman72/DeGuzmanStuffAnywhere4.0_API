package com.deguzman.DeGuzmanStuffAnywhere.chat.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.deguzman.DeGuzmanStuffAnywhere.chat.model.Message;

@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messageTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent evnet) {
		logger.info("Received a new web socket connection");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if (username != null) {
			
			logger.info("User disconnected: " + username);
			
			Message message = new Message();
			
			message.setContent("User has left");
			message.setSender(username);
			
			messageTemplate.convertAndSend("/topic/public", message);
		}
	}
}
