package com.springboot.kafka.dto;

import com.springboot.kafka.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MySqlMongoSyncTopic1Dto {

	private Company company;
	private String crudOps;
}
