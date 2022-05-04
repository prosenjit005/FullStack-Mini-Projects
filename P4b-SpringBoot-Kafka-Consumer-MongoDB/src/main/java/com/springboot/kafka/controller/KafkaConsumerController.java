package com.springboot.kafka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.dto.MySqlMongoSyncTopic1Dto;
import com.springboot.kafka.entities.Company;
import com.springboot.kafka.services.SpringbootMongoDbService;

@RestController
public class KafkaConsumerController {

	List<String> messages = new ArrayList<>();

	@Autowired
	SpringbootMongoDbService springbootMongoDbService;

	@KafkaListener(groupId = "#{'${kafka.topic.name}'}"
			+ "-1", topics = "#{'${kafka.topic.name}'}", containerFactory = "consumerKafkaListenerContainerFactory")
	public Company getJsonMsgFromTopic(MySqlMongoSyncTopic1Dto mySqlMongoSyncTopic1Dto) {
		Company company = springbootMongoDbService.mongoDbCrudOps(mySqlMongoSyncTopic1Dto);
		return company;
	}
}
