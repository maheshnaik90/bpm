package com.lgc.ctps.sgec.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lgc.ctps.sgec.domain.Company;
import com.lgc.ctps.sgec.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company findOne(Long id) {
		Company companySaved = companyRepository.findOne(id);
		if (companySaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return companySaved;
	}

	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public void delete(Long id) {
		companyRepository.delete(id);
	}

	public Company update(Long codigo, Company company) {
		Company companySaved = findOne(codigo);
		BeanUtils.copyProperties(company, companySaved, "id");
		return companyRepository.save(companySaved);
	}

	public void disable(Long codigo, Boolean ativo) {
		Company companySaved = findOne(codigo);
		//companySaved.setAtivo(ativo);
		companyRepository.save(companySaved);
	}
}
