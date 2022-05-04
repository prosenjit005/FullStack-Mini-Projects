package com.springboot.kafka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springboot.kafka.dto.MySqlMongoSyncTopic1Dto;
import com.springboot.kafka.entities.Company;
import com.springboot.kafka.repository.CompanyRepository;

@Service
public class SpringbootMySqlServiceImpl implements SpringbootMySqlService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private KafkaTemplate<String, Object> template;

	@Autowired
	private Environment env;

	@Override
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> saveAllCompanies(List<Company> companiesList) {
		return companyRepository.saveAll(companiesList);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyById(Integer id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public Company getCompanyByCompanyCode(String companyCode) {
		return companyRepository.findByCompanyCode(companyCode);
	}

	@Override
	public Company deleteCompanyById(Integer id) {
		Company company = companyRepository.findById(id).orElse(null);
		companyRepository.deleteById(id);
		return company;
	}

	@Override
	public Company updateCompany(Company company) {
		Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
		existingCompany.setCompanyName(company.getCompanyName());
		existingCompany.setCompanyCEO(company.getCompanyCEO());
		return companyRepository.save(existingCompany);
	}

	@Override
	public void sendToKafka(Company company, String CRUD) {
		MySqlMongoSyncTopic1Dto mySqlMongoSyncTopic1Dto = new MySqlMongoSyncTopic1Dto();
		mySqlMongoSyncTopic1Dto.setCompany(company);
		mySqlMongoSyncTopic1Dto.setCrudOps(CRUD);
		template.send(env.getProperty("kafka.topic.name"), mySqlMongoSyncTopic1Dto);
	}

}
