package com.lgc.ctps.sgec.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgc.ctps.sgec.domain.Sample;
import com.lgc.ctps.sgec.service.SampleService;

@RestController
@RequestMapping("sample")
public class SampleResource {

	@Autowired
	private SampleService sampleService;
	
	@PostMapping
	public ResponseEntity<Sample> save(@Valid @RequestBody Sample sample,
			HttpServletResponse httpServletResponse) {
		Sample sampleSaved = sampleService.save(sample);		
		return ResponseEntity.status(HttpStatus.CREATED).body(sampleSaved);
	}

}
