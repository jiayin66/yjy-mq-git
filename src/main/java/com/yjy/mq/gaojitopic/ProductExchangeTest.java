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
		 * ���ν�������ת��ȫ��  fanout exchange
			ֱ����������ת����ָ����һ����ͨ��·�ɼ� direct exchange
			���⽻������ת�����֣�·��ֵ  topic exchange
			ͷ��������headers exchange
		 */
		DeclareOk exchangeDeclare = channel.exchangeDeclare(exchangeName, "fanout");
		for(int i=0;i<10;i++) {
			//�ڶ�������Ϊ·�ɼ������ַ���Ϊ����
			channel.basicPublish(exchangeName, "", null, ("۳����"+i).getBytes());
		}
		System.out.println("������Ͷ����Ϣ�ɹ�");
//		channel.close();
//		newConnection.close();
	}
}	
