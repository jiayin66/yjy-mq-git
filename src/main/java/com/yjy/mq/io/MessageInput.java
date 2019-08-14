package com.yjy.mq.io;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MessageInput {
	 String EXCHANGE_NAME="event_yjy";
	    @Input(EXCHANGE_NAME)
	    MessageChannel getInputChannel();
}
