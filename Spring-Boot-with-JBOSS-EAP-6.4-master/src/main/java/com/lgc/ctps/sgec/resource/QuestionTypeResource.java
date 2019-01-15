package com.lgc.ctps.sgec.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgc.ctps.sgec.domain.QuestionType;
import com.lgc.ctps.sgec.repository.QuestionTypeRepository;
 
@RestController
@RequestMapping("question-types")
public class QuestionTypeResource {  
	
	@Autowired
	private QuestionTypeRepository questionTypeRepository;

	@GetMapping
	public List<QuestionType> list() {
		return questionTypeRepository.findAll();
	} 
}
