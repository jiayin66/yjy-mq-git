package com.yjy.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FunConfig {
	// �ʼ�����
		private String FANOUT_EMAIL_QUEUE = "fanout_eamil_queue";

		// ���Ŷ���
		private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
		// ���Ŷ���
		private String EXCHANGE_NAME = "fanoutExchange";

		// 1.��������ʼ�
		@Bean
		public Queue fanOutEamilQueue() {
			return new Queue(FANOUT_EMAIL_QUEUE);
		}

		@Bean
		public Queue fanOutSmsQueue() {
			return new Queue(FANOUT_SMS_QUEUE);
		}

		// 2.���彻����
		@Bean
		FanoutExchange fanoutExchange() {
			return new FanoutExchange(EXCHANGE_NAME);
		}

		// 3.�����뽻�������ʼ�����
		@Bean
		Binding bindingExchangeEamil(Queue fanOutEamilQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(fanOutEamilQueue).to(fanoutExchange);
		}

		// 4.�����뽻�����󶨶��Ŷ���
		@Bean
		Binding bindingExchangeSms(Queue fanOutSmsQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(fanOutSmsQueue).to(fanoutExchange);
		}
}
