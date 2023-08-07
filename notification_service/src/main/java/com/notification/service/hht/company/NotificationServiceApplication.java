package com.notification.service.hht.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableBinding(Sink.class)
public class NotificationServiceApplication {

	@StreamListener(Sink.INPUT)
	public void consumeMessage(String message) {
		System.out.println("message");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}
