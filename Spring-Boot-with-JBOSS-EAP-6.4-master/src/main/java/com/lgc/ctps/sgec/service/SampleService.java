package com.lgc.ctps.sgec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgc.ctps.sgec.domain.Sample;
import com.lgc.ctps.sgec.repository.SampleRepository;

@Service
public class SampleService {

	@Autowired
	SampleRepository sampleRepository;

	

	public void setSampleRepository(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}



	public Sample save(Sample sample) {
		return sampleRepository.save(sample);
	}

	
}
