package com.yjy.mq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProductTopicTest {
	/**
	 * mq通讯地址
	 */
	private final static String URL = "tcp://localhost:61616";
	/**
	 * 队列名称
	 */
	private final static String topicName = "my_topic";
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory (URL);
		Connection createConnection = factory.createConnection();
		createConnection.start();
		//第一个参数true代表事务方式
		Session createSession = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic createTopic = createSession.createTopic(topicName);
		MessageProducer createProducer = createSession.createProducer(createTopic);
		for(int i=0;i<10;i++) {
			TextMessage createTextMessage = createSession.createTextMessage("message"+i);
			createProducer.send(createTextMessage);
			/**
			 * 事务提交
			 */
		//	createSession.commit();
			
		}
	}
}
