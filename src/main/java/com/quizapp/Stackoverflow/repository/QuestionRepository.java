package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
