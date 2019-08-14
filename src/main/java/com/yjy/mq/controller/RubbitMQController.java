package com.yjy.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.mq.io.MessageOutPut;

@RestController
public class RubbitMQController {
	@Autowired
	private MessageOutPut messageOutPut;

	@RequestMapping("/sendstream/{message}")
	public String sendStream(@PathVariable("message") String message) {
		Message<String> buildMessage = MessageBuilder.withPayload(message).build();
		messageOutPut.getOutputChannel().send(buildMessage);
		return "sucess";
	}
}
