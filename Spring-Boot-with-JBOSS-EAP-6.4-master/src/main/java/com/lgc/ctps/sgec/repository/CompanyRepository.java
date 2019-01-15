package com.lgc.ctps.sgec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lgc.ctps.sgec.domain.Company;
 

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
