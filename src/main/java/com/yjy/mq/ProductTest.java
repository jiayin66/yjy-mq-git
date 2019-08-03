package com.yjy.mq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductTest implements CommandLineRunner{
	@Autowired
	private Topic topic;
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void sendMessage() {
		for(int i=0;i<10;i++) {
			jmsMessagingTemplate.convertAndSend(topic, "ÏûÏ¢"+i);
		}
		
	}

	public void run(String... arg0) throws Exception {
		sendMessage();
		
	}
}