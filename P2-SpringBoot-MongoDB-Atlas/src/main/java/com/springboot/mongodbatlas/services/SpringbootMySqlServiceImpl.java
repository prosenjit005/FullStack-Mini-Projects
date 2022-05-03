package com.springboot.mongodbatlas.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.springboot.mongodbatlas.entities.Company;
import com.springboot.mongodbatlas.entities.CompanySequence;
import com.springboot.mongodbatlas.repository.CompanyRepository;

@Service
public class SpringbootMySqlServiceImpl implements SpringbootMySqlService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private MongoOperations mongoOperations;

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
	public String deleteCompanyById(Integer id) {
		companyRepository.deleteById(id);
		return "Company deleted with id=" + id;
	}

	@Override
	public Company updateCompany(Company company) {
		Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
		existingCompany.setCompanyName(company.getCompanyName());
		existingCompany.setCompanyCEO(company.getCompanyCEO());
		return companyRepository.save(existingCompany);
	}

	@Override
	public int getCompanySequenceNumber(String sequenceName) {
		// get sequence number
		Query query = new Query(Criteria.where("id").is(sequenceName));
		// update the sequnce number
		Update update = new Update().inc("seq", 1);
		// modify in document
		CompanySequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
				CompanySequence.class);

		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

}
