package com.yjy.mq.putong;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.yjy.mq.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ProductQueueTest {
	
	private static String queueName="text-message";
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection newConnection = MQConnectionUtils.newConnection();
		Channel channel = newConnection.createChannel();
		DeclareOk queueDeclare = channel.queueDeclare(queueName, false, false, false, null);
		for(int i=0;i<20;i++) {
			channel.basicPublish("", queueName, null, ("۳����"+i).getBytes());
		}
		System.out.println("������Ͷ����Ϣ�ɹ�");
		channel.close();
		newConnection.close();
	}
}	
