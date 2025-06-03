package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByUserAndQuestion(User user, Question question);
    boolean existsByUserAndAnswer(User user, Answer answer);

}
