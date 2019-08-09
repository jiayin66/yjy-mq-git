package com.yjy.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ProductTest {
	
	private static String queueName="text-message";
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection newConnection = MQConnectionUtils.newConnection();
		Channel channel = newConnection.createChannel();
		DeclareOk queueDeclare = channel.queueDeclare(queueName, false, false, false, null);
		channel.basicPublish("", queueName, null, "۳����".getBytes());
		System.out.println("������Ͷ����Ϣ�ɹ�");
		channel.close();
		newConnection.close();
	}
}	
