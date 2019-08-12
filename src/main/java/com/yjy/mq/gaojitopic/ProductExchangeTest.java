package com.yjy.mq.gaojitopic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.yjy.mq.MQConnectionUtils;
import com.rabbitmq.client.AMQP.Exchange.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ProductExchangeTest {
	
	private static String exchangeName="esb-message";
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection newConnection = MQConnectionUtils.newConnection();
		Channel channel = newConnection.createChannel();
		/*
		 * 扇形交换机：转发全部  fanout exchange
			直连交换机：转发到指定的一个，通过路由键 direct exchange
			主题交换机：转发部分，路由值  topic exchange
			头交换机：headers exchange
		 */
		DeclareOk exchangeDeclare = channel.exchangeDeclare(exchangeName, "fanout");
		for(int i=0;i<10;i++) {
			//第二个参数为路由键，空字符串为不传
			channel.basicPublish(exchangeName, "", null, ("鄢家银"+i).getBytes());
		}
		System.out.println("生产者投递消息成功");
//		channel.close();
//		newConnection.close();
	}
}	
