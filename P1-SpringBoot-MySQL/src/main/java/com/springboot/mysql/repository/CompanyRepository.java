package com.springboot.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mysql.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findByCompanyCode(String companyCode);

}
