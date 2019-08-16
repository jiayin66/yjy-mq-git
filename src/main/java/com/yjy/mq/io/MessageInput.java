package com.yjy.mq.io;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageInput {
	 String EXCHANGE_NAME="event_yjy1";
	    @Input(EXCHANGE_NAME)
	    SubscribableChannel  getInputChannel();
}
