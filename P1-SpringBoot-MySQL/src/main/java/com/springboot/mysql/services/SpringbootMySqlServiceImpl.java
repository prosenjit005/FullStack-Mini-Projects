package com.springboot.mysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mysql.entities.Company;
import com.springboot.mysql.repository.CompanyRepository;

@Service
public class SpringbootMySqlServiceImpl implements SpringbootMySqlService {

	@Autowired
	private CompanyRepository companyRepository;

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
		return "Company deleted with id="+id;
	}

	@Override
	public Company updateCompany(Company company) {
		Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
		existingCompany.setCompanyName(company.getCompanyName());
		existingCompany.setCompanyCEO(company.getCompanyCEO());
		return companyRepository.save(existingCompany);
	}

}
