package com.example.eCommerce.publisher;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
	
	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	private String topicString = "topic1";

	
	@Autowired
	public Publisher(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}



	public void sendToKafka(String testMessage) {
		Message<String> message = MessageBuilder
				.withPayload(testMessage)
				.setHeader(KafkaHeaders.TOPIC, topicString)
				.setHeader(KafkaHeaders.KEY, "12345")
				.build();
		
		CompletableFuture<SendResult<String, Object>> future  = kafkaTemplate.send(message);
		
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				logger.info("Message published: {}", message);
			} else {
				logger.error("Error: {}", ex);
			}
		});
	}
}
