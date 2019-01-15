package com.lgc.ctps.sgec.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgc.ctps.sgec.domain.QuestionType;
import com.lgc.ctps.sgec.repository.QuestionTypeRepository;

@Service
public class QuestionTypeService {

	@Autowired
	QuestionTypeRepository questionTypeRepository;

	public List<QuestionType> findAll() {
		return questionTypeRepository.findAll();
	}

	public QuestionType save(QuestionType questionType) {
		return questionTypeRepository.save(questionType);
	}

	public QuestionType findOne(Long id) {
		return questionTypeRepository.findOne(id);
	}

	public void delete(Long id) {
		questionTypeRepository.delete(id);
	}

	public QuestionType update(Long id, QuestionType questionType) {
		QuestionType questionTypeSaved = findOne(id);
		BeanUtils.copyProperties(questionType, questionTypeSaved, "id");
		return questionTypeRepository.save(questionTypeSaved);
	}
}
