package com.yjy.mq.io;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageOutPut {
	String EXCHANGE_NAME="event_yjy";
	
	  @Output(EXCHANGE_NAME)
	  MessageChannel getOutputChannel();
	  
	/*  @Input(EXCHANGE_NAME)
	  MessageChannel getInputChannel();*/
}
