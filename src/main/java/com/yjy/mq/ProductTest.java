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
		channel.basicPublish("", queueName, null, "鄢家银".getBytes());
		System.out.println("生产者投递消息成功");
		channel.close();
		newConnection.close();
	}
}	
