package com.springboot.kafka.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springboot.kafka.entities.Company;

public interface CompanyRepository extends MongoRepository<Company, Integer> {

	@Query("{companyCode :?0}")
	Company findByCompanyCode(String companyCode);

}
