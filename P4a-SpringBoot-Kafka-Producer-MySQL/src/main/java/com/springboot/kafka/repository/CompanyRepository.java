package com.springboot.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.kafka.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findByCompanyCode(String companyCode);

}
