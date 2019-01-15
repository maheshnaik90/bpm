package com.lgc.ctps.sgec.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgc.ctps.sgec.domain.Question;
import com.lgc.ctps.sgec.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	public Question save(Question question) {
		return questionRepository.save(question);
	}

	public Question findOne(Long id) {
		return questionRepository.findOne(id);
	}

	public void delete(Long id) {
		questionRepository.delete(id);
	}

	public Question update(Long id, Question question) {
		Question questionSaved = findOne(id);
		BeanUtils.copyProperties(question, questionSaved, "id");
		return questionRepository.save(questionSaved);
	}
}
