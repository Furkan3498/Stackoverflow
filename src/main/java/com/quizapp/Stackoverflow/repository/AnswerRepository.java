package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    int countByUser(User user);
    List<Answer> findByUser(User user);
    List<Answer> findByAuthor(User author);
    List<Answer> findByQuestionId(Long questionId);
}
