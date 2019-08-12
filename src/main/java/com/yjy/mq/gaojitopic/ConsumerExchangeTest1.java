package com.yjy.mq.gaojitopic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.yjy.mq.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ConsumerExchangeTest1 {
	private static String exchangeName="esb-message";
	private static String queueName="text-esb-message1";
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection newConnection = MQConnectionUtils.newConnection();
		final	Channel channel = newConnection.createChannel();
		//��ͨ��������������
		DeclareOk queueDeclare = channel.queueDeclare(queueName, false, false, false, null);
		//ͨ���ͽ������󶨣���������·�ɲ��ԣ�������ʾ������
		channel.queueBind(queueName, exchangeName, "");
		DefaultConsumer defaultConsumer =new DefaultConsumer (channel) {

			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msgString = new String(body, "UTF-8");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("������1��ȡ��Ϣ:" + msgString);
				if(true)
				//throw new RuntimeException("�����쳣");
			
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};

		// 3.��������
		//�ڶ���������true��ʾ�Զ���false�ֶ�
		channel.basicConsume(queueName, false, defaultConsumer);

		
	}
}	
