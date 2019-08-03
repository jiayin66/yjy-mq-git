package com.yjy.mq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumerQueueTest {
	/**
	 * mq通讯地址
	 */
	private final static String URL = "tcp://localhost:61616";
	private final static String QUEUENAME = "my_queue";
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory (URL);
		Connection createConnection = factory.createConnection();
		createConnection.start();
		final Session createSession = createConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue createQueue = createSession.createQueue(QUEUENAME);
		MessageConsumer createConsumer = createSession.createConsumer(createQueue);
		createConsumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage TextMessage=(TextMessage)message;
				String text=null;
				try {
					text = TextMessage.getText();
					
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**
				 * 这段代码就是手动签收用的
				 */
				try {
					TextMessage.acknowledge();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(text);
				try {
					createSession.commit();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
