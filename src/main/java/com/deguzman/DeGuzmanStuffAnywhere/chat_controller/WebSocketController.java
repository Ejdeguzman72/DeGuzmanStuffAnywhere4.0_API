package com.deguzman.DeGuzmanStuffAnywhere.chat_controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.chat_model.MessageBean;

@RestController
@CrossOrigin
public class WebSocketController {
	
	@MessageMapping("/user-all")
	@SendTo("/topic/user")
	public MessageBean sendToAll(@Payload MessageBean message) {
		return message;
	}
	
}
