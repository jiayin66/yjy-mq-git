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
		//给通道申明队列名称
		DeclareOk queueDeclare = channel.queueDeclare(queueName, false, false, false, null);
		//通道和交换机绑定，可以设置路由策略，“”表示不设置
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
				System.out.println("消费者1获取消息:" + msgString);
				if(true)
				//throw new RuntimeException("测试异常");
			
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};

		// 3.监听队列
		//第二个参数是true表示自动，false手动
		channel.basicConsume(queueName, false, defaultConsumer);

		
	}
}	
