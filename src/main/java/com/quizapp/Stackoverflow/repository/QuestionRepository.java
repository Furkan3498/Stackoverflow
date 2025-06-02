package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    int countByUser(User user);
    List<Question> findByUser(User user);
    List<Question> findByTagsNameIgnoreCase(String tagName);
    @Query("SELECT q FROM Question q LEFT JOIN q.upvotes u GROUP BY q.id ORDER BY COUNT(u) DESC")
    List<Question> findAllOrderByUpvoteCountDesc();
}
