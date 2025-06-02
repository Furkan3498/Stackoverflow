package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    int countByUser(User user);
    List<Question> findByUser(User user);
    List<Question> findByTagsNameIgnoreCase(String tagName);
}
