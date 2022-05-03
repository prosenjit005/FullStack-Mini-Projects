package com.springboot.kafka.entities;

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
public class Company {

	private Integer id;
	private String companyCode;
	private String companyName;

	private String companyCEO;
	private Double companyTurnover;
	private String companyWebsite;
	private String stockExchange;

}
