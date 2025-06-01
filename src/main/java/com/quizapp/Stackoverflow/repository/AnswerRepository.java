package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
