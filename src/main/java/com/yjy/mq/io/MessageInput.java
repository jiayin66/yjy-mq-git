package com.yjy.mq.io;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageInput {
	 String EXCHANGE_NAME="event_yjy";
	    @Input(EXCHANGE_NAME)
	    SubscribableChannel  getInputChannel();
	    @Input("event_yjy1")
	    SubscribableChannel  getInputChannel2();
}
