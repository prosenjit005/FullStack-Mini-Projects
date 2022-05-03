package com.springboot.mysql.controller;

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

import com.springboot.mysql.entities.Company;
import com.springboot.mysql.services.SpringbootMySqlService;

@RestController
@RequestMapping("companyapi")
public class SpringbootMySqlController {

	@Autowired
	private SpringbootMySqlService springbootMySqlService;

	@PostMapping("/addCompany")
	public Company addCompany(@RequestBody Company company) {
		return springbootMySqlService.saveCompany(company);
	}

	@PostMapping("/addCompanies")
	public List<Company> addCompanies(@RequestBody List<Company> companies) {
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
