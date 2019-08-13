package com.yjy.mq.topic;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductTest {
	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String queueName) {
		String msg = "my_fanout_msg:" + new Date();
		System.out.println(msg + ":" + msg);
		amqpTemplate.convertAndSend(queueName, "",msg);
	
	}
}
