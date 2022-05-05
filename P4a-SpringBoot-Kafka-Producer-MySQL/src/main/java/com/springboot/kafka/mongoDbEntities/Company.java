package com.springboot.kafka.mongoDbEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "company")
public class Company {

	@Transient
	public static final String COMPANY_SEQUENCE_NAME = "company_sequence";

	@Id
	private Integer id;
	private String companyCode;
	private String companyName;

	private String companyCEO;
	private Double companyTurnover;
	private String companyWebsite;
	private String stockExchange;

}
