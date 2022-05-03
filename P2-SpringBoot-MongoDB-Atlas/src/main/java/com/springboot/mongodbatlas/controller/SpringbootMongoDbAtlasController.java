package com.springboot.mongodbatlas.controller;

import static com.springboot.mongodbatlas.entities.Company.COMPANY_SEQUENCE_NAME;

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

import com.springboot.mongodbatlas.entities.Company;
import com.springboot.mongodbatlas.services.SpringbootMySqlService;

@RestController
@RequestMapping("companyapi")
public class SpringbootMongoDbAtlasController {

	@Autowired
	private SpringbootMySqlService springbootMySqlService;

	@GetMapping("/test")
	public String test() {
		return "SpringbootMongoDbAtlasController endpoint hit success !!!";
	}

	@PostMapping("/addCompany")
	public Company addCompany(@RequestBody Company company) {
		// generate sequence
		company.setId(springbootMySqlService.getCompanySequenceNumber(COMPANY_SEQUENCE_NAME));

		return springbootMySqlService.saveCompany(company);
	}

	@PostMapping("/addCompanies")
	public List<Company> addCompanies(@RequestBody List<Company> companies) {
		//TODO: Test
		for(Company company:companies) {
			// generate sequence
			company.setId(springbootMySqlService.getCompanySequenceNumber(COMPANY_SEQUENCE_NAME));
		}
		return springbootMySqlService.saveAllCompanies(companies);
	}

	@GetMapping("/getCompanies")
	public List<Company> findAllCompanies() {
		return springbootMySqlService.getAllCompanies();
	}

	@GetMapping("/companyId/{id}")
	public Company findCompanyById(@PathVariable Integer id) {
		return springbootMySqlService.getCompanyById(id);
	}

	@GetMapping("/companyCode/{code}")
	public Company findCompanyByCode(@PathVariable String code) {
		return springbootMySqlService.getCompanyByCompanyCode(code);
	}

	@PutMapping("/updateCompany")
	public Company updateCompany(@RequestBody Company company) {
		return springbootMySqlService.updateCompany(company);
	}

	@DeleteMapping("/deleteCompany/{id}")
	public String deleteCompany(@PathVariable Integer id) {
		return springbootMySqlService.deleteCompanyById(id);
	}

}
