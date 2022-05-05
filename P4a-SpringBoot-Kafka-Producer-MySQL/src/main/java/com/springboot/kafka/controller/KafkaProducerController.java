package com.springboot.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.entities.Company;
import com.springboot.kafka.repository.CompanyMongoDbRepository;
import com.springboot.kafka.services.SpringbootMySqlService;

@RestController
@RequestMapping("companyapi")
public class KafkaProducerController {

	@Autowired
	private CompanyMongoDbRepository companyMongoDbRepository;

	private String CRUD_C = "C";
	private String CRUD_U = "U";
	private String CRUD_D = "D";

	@Autowired
	private SpringbootMySqlService springbootMySqlService;

	@PostMapping("/addCompany")
	public Company addCompany(@RequestBody Company company) {
		// creating the company in the MySQL DB
		Company companyReturn = springbootMySqlService.saveCompany(company);

		// publishing in the topic so that MongoDB can also be in sync
		if (null != companyReturn) {
			springbootMySqlService.sendToKafka(companyReturn, CRUD_C);
		}
		return companyReturn;
	}

	@PostMapping("/addCompanies")
	public List<Company> addCompanies(@RequestBody List<Company> companies) {
		List<Company> companyList = springbootMySqlService.saveAllCompanies(companies);

		// publishing in the topic so that MongoDB can also be in sync
		if (null != companyList && !companyList.isEmpty()) {
			for (Company company : companyList) {
				springbootMySqlService.sendToKafka(company, CRUD_C);
			}
		}
		return companyList;
	}

	@GetMapping("/getCompanies")
	public List<com.springboot.kafka.mongoDbEntities.Company> findAllCompanies() {
		// for this Read operation we will use
		// MongoDB instead of MySQL
		List<com.springboot.kafka.mongoDbEntities.Company> companyList = companyMongoDbRepository.findAll();
		return companyList;
	}

	@GetMapping("/companyId/{id}")
	public Company findCompanyById(@PathVariable Integer id) {
		//TODO with mongoDB
		return springbootMySqlService.getCompanyById(id);
	}

	@GetMapping("/companyCode/{code}")
	public Company findCompanyByCode(@PathVariable String code) {
		//TODO with mongoDB
		return springbootMySqlService.getCompanyByCompanyCode(code);
	}

	@PutMapping("/updateCompany")
	public Company updateCompany(@RequestBody Company company) {
		Company companyReturn = springbootMySqlService.updateCompany(company);

		// publishing in the topic so that MongoDB can also be in sync
		if (null != companyReturn) {
			springbootMySqlService.sendToKafka(companyReturn, CRUD_U);
		}
		return companyReturn;
	}

	@DeleteMapping("/deleteCompany/{id}")
	public Company deleteCompany(@PathVariable Integer id) {
		Company company = springbootMySqlService.deleteCompanyById(id);

		// publishing in the topic so that MongoDB can also be in sync
		if (null != company) {
			springbootMySqlService.sendToKafka(company, CRUD_D);
		}
		return company;
	}

}
