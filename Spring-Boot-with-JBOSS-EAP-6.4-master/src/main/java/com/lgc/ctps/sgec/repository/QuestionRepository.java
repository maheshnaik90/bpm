package com.lgc.ctps.sgec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lgc.ctps.sgec.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
