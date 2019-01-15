package com.lgc.ctps.sgec.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lgc.ctps.sgec.domain.Company;
import com.lgc.ctps.sgec.event.CreatedResourceEvent;
import com.lgc.ctps.sgec.service.CompanyService;

@RestController
@RequestMapping("companies")
public class CompanyResource {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@GetMapping
	public List<Company> findAll() {
		return companyService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> findOne(@PathVariable Long id) {
		Company companyFound = companyService.findOne(id);
		return !ObjectUtils.isEmpty(companyFound) ? ResponseEntity.ok(companyFound)
				: ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Company> save(@Valid @RequestBody Company company,
			HttpServletResponse httpServletResponse) {
		Company companySaved = companyService.save(company);
		/*applicationEventPublisher.publishEvent(
				new CreatedResourceEvent(this, httpServletResponse, companySaved.getId()));*/
		return ResponseEntity.status(HttpStatus.CREATED).body(companySaved);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		companyService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> update(@PathVariable Long codigo,
			@Valid @RequestBody Company company) {
		Company companySaved = companyService.update(codigo, company);
		return ResponseEntity.ok(companySaved);
	}

	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void disable(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		companyService.disable(codigo, ativo);
	}
}
