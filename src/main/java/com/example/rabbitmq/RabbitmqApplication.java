package com.example.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

	/*DelaySender 1537954015391,Wed Sep 26 17:26:55 CST 2018
TradeProcessor  message::Wed Sep 26 17:27:00 CST 2018:{"content":"1537954015391","exchange":"KSHOP","queueName":"delayProcess","times":5000}
DelayProcessor  process::Wed Sep 26 17:27:00 CST 2018:1537954015391
*/
}
