package com.springboot.kafka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.entities.Company;

@RestController
public class KafkaConsumerController {

	List<String> messages = new ArrayList<>();

	Company companyFromTopic = null;

	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}

	@GetMapping("/consumeJsonMessage")
	public Company consumeJsonMessage() {
		return companyFromTopic;
	}

	@KafkaListener(groupId = "demo1topic-1", topics = "demo1topic", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
	}

	@KafkaListener(groupId = "demo1topic-2", topics = "demo1topic", containerFactory = "userKafkaListenerContainerFactory")
	public Company getJsonMsgFromTopic(Company company) {
		companyFromTopic = company;
		return companyFromTopic;
	}
}
