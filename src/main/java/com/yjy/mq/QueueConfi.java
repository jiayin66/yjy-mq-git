package com.yjy.mq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueConfi {
	@Value("${topicname}")
	private String topicname;
	@Bean
	public Topic getTopic() {
		return new ActiveMQTopic(topicname);
	}
}
