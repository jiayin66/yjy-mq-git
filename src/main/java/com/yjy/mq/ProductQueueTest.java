package com.yjy.mq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProductQueueTest {
	/**
	 * mq通讯地址
	 */
	private final static String URL = "tcp://localhost:61616";
	/**
	 * 队列名称
	 */
	private final static String QUEUENAME = "my_queue";
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory (URL);
		Connection createConnection = factory.createConnection();
		createConnection.start();
		//第一个参数true代表事务方式
		Session createSession = createConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue createQueue = createSession.createQueue(QUEUENAME);
		MessageProducer createProducer = createSession.createProducer(createQueue);
		for(int i=0;i<10;i++) {
			TextMessage createTextMessage = createSession.createTextMessage("message"+i);
			createProducer.send(createTextMessage);
			/**
			 * 事务提交
			 */
			createSession.commit();
			
		}
	}
}
