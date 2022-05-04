package com.springboot.kafka.services;

import com.springboot.kafka.dto.MySqlMongoSyncTopic1Dto;
import com.springboot.kafka.entities.Company;

public interface SpringbootMongoDbService {

	Company mongoDbCrudOps(MySqlMongoSyncTopic1Dto mySqlMongoSyncTopic1Dto);

}
