package com.springboot.mysql.services;

import java.util.List;

import com.springboot.mysql.entities.Company;

public interface SpringbootMySqlService {

	Company saveCompany(Company company);

	List<Company> saveAllCompanies(List<Company> companiesList);

	List<Company> getAllCompanies();

	Company getCompanyById(Integer id);

	Company getCompanyByCompanyCode(String companyCode);

	String deleteCompanyById(Integer id);

	Company updateCompany(Company company);
}
