package com.yjy.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailTest implements CommandLineRunner{
	
	@Autowired
	JavaMailSender javaMailSender;

	public void run(String... arg0) throws Exception {
		for(int i=0;i<10;i++) {
			sendSimpleMail("zypyjy@163.com");
			Thread.sleep(2000);
		}
	}
	
	public void sendSimpleMail(String eamil) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(eamil);
		message.setTo("501023696@qq.com");
		message.setSubject("蚂蚁课堂|每特教育 新学员提醒");
		message.setText("祝贺您,成为了我们" + ",学员!");
		javaMailSender.send(message);
		System.out.println("邮件发送完成" );
	}
}
