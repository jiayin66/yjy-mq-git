package com.yjy.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.mq.topic.ProductTest;

@RestController
public class RubbitMQController {
	@Autowired
	private ProductTest fanoutProducer;

	@RequestMapping("/sendFanout/{queueName}")
	public String sendFanout(@PathVariable("queueName") String queueName) {
		fanoutProducer.send(queueName);
		return "success";
	}
}
