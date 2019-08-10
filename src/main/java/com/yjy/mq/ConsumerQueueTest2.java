package com.yjy.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ConsumerQueueTest2 {
	
	private static String queueName="text-message";
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection newConnection = MQConnectionUtils.newConnection();
	final	Channel channel = newConnection.createChannel();
	channel.basicQos(1);
		DeclareOk queueDeclare = channel.queueDeclare(queueName, false, false, false, null);
		DefaultConsumer defaultConsumer =new DefaultConsumer (channel) {

			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msgString = new String(body, "UTF-8");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("消费者2获取消息:" + msgString);
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};

		// 3.监听队列
		channel.basicConsume(queueName, false, defaultConsumer);

		
	}
}	
