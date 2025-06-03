package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findAllByOrderByCreatedAtDesc();
}
