package com.yjy.mq.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

import com.yjy.mq.io.MessageOutPut;

@EnableBinding(MessageOutPut.class)
@Component
public class TestClass {

}
