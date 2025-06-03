package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.VoteRequestDTO;
import com.quizapp.Stackoverflow.model.*;
import com.quizapp.Stackoverflow.repository.AnswerRepository;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import com.quizapp.Stackoverflow.repository.VoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserService userService;

    public void upvoteQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Vote vote = new Vote();
        vote.setQuestion(question);
        vote.setUser(userService.getCurrentUser());
        vote.setType(VoteType.UPVOTE);
        voteRepository.save(vote);
    }

    public void downvoteAnswer(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        Vote vote = new Vote();
        vote.setAnswer(answer);
        vote.setUser(userService.getCurrentUser());
        vote.setType(VoteType.DOWNVOTE);
        voteRepository.save(vote);
    }
}


