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
	 * mqͨѶ��ַ
	 */
	private final static String URL = "tcp://localhost:61616";
	/**
	 * ��������
	 */
	private final static String QUEUENAME = "my_queue";
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory (URL);
		Connection createConnection = factory.createConnection();
		createConnection.start();
		//��һ������true��������ʽ
		Session createSession = createConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue createQueue = createSession.createQueue(QUEUENAME);
		MessageProducer createProducer = createSession.createProducer(createQueue);
		for(int i=0;i<10;i++) {
			TextMessage createTextMessage = createSession.createTextMessage("message"+i);
			createProducer.send(createTextMessage);
			/**
			 * �����ύ
			 */
			createSession.commit();
			
		}
	}
}
