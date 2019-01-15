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

import com.lgc.ctps.sgec.domain.Question;
import com.lgc.ctps.sgec.event.CreatedResourceEvent;
import com.lgc.ctps.sgec.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionResource {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@GetMapping
	public List<Question> findAll() {
		return questionService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> findOne(@PathVariable Long id) {
		Question questionFound = questionService.findOne(id);
		return !ObjectUtils.isEmpty(questionFound) ? ResponseEntity.ok(questionFound)
				: ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Question> save(@Valid @RequestBody Question question,
			HttpServletResponse httpServletResponse) {
		Question questionSaved = questionService.save(question);
		/*applicationEventPublisher.publishEvent(
				new CreatedResourceEvent(this, httpServletResponse, questionSaved.getId()));*/
		return ResponseEntity.status(HttpStatus.CREATED).body(questionSaved);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		questionService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Question> update(@PathVariable Long id,
			@Valid @RequestBody Question question) {
		Question questionSaved = questionService.update(id, question);
		return ResponseEntity.ok(questionSaved);
	}
}
