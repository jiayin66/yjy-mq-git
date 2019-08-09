package com.yjy.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MQConnectionUtils {
	public static Connection newConnection() throws IOException, TimeoutException {
		ConnectionFactory factory =new ConnectionFactory ();
		factory.setHost("127.0.0.1");
		factory.setUsername("admin_yjy");
		factory.setPassword("123456");
		factory.setVirtualHost("/yjy");
		factory.setPort(5672);
		Connection newConnection = factory.newConnection();
		return newConnection;
	}
}
