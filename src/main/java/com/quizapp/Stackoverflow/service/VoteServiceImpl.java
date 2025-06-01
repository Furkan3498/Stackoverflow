package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.repository.AnswerRepository;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements  IVoteService{

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    @Override
    public String voteQuestion(Long questionId, boolean upvote, String username) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
        int change = upvote ? 1 : -1;
        question.setVoteCount(question.getVoteCount() + change);
        questionRepository.save(question);
        return upvote ? "Question upvoted" : "Question downvoted";
    }

    @Override
    public String voteAnswer(Long answerId, boolean upvote, String username) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found"));
        int change = upvote ? 1 : -1;
        answer.setVoteCount(answer.getVoteCount() + change);
        answerRepository.save(answer);
        return upvote ? "Answer upvoted" : "Answer downvoted";
    }
}
