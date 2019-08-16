package com.yjy.mq.io;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageOutPut {
	String EXCHANGE_NAME="event_yjy1";

	  @Output(EXCHANGE_NAME)
	  SubscribableChannel  getOutputChannel();
}
