package com.yjy.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "fanout_eamil_queue")
public class ConsumerTest {
	@RabbitHandler
	public void process(String msg) throws Exception {
		System.out.println("�ʼ������߻�ȡ��������Ϣmsg:" + msg);
	}
}
