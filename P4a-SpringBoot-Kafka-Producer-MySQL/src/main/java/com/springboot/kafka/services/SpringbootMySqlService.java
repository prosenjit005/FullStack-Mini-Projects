package com.springboot.kafka.services;

import java.util.List;

import com.springboot.kafka.entities.Company;

public interface SpringbootMySqlService {

	Company saveCompany(Company company);

	List<Company> saveAllCompanies(List<Company> companiesList);

	List<Company> getAllCompanies();

	Company getCompanyById(Integer id);

	Company getCompanyByCompanyCode(String companyCode);

	Company deleteCompanyById(Integer id);

	Company updateCompany(Company company);

	void sendToKafka(Company company, String CRUD);
}
