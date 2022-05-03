package com.springboot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.entities.Company;

@RestController
public class KafkaProducerController {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "demo1topic";

	@GetMapping("/publish/{name}")
	public String publishMessage1(@PathVariable String name) {
		template.send(topic, "Hi " + name + " Welcome to java.");
		return "Data published";
	}

	@GetMapping("/publishJson")
	public String publishMessage2() {
		Company company = new Company(1, "C001", "companyName1", "companyCEO", 28.56, "companyWebsite1", "NSE");
		template.send(topic, company);
		return "Json Data published";
	}

}
