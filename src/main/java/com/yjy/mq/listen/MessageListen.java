package com.yjy.mq.listen;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.yjy.mq.io.MessageInput;

//@Service
//@EnableBinding(MessageInput.class)
//public class MessageListen {
//	@StreamListener(MessageInput.EXCHANGE_NAME)
//	public void getMessage(String message) {
//		System.out.println(message);
//	}
//}
