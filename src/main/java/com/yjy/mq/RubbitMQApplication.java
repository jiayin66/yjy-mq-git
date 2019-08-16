package com.yjy.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.yjy.mq.io.MessageOutPut;

@SpringBootApplication
public class RubbitMQApplication {
	public static void main(String[] args) {
		SpringApplication.run(RubbitMQApplication.class, args);
	}
}
