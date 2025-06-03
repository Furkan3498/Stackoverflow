package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.VoteRequestDTO;
import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.model.Vote;
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
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public Vote vote(VoteRequestDTO dto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.getQuestionId() != null) {
            Question question = questionRepository.findById(dto.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            if (voteRepository.existsByUserAndQuestion(user, question)) {
                throw new RuntimeException("Already voted");
            }

            Vote vote = new Vote();
            vote.setUser(user);
            vote.setQuestion(question);
            vote.setUpvote(dto.isUpvote());
            return voteRepository.save(vote);
        }

        if (dto.getAnswerId() != null) {
            Answer answer = answerRepository.findById(dto.getAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            if (voteRepository.existsByUserAndAnswer(user, answer)) {
                throw new RuntimeException("Already voted");
            }

            Vote vote = new Vote();
            vote.setUser(user);
            vote.setAnswer(answer);
            vote.setUpvote(dto.isUpvote());
            return voteRepository.save(vote);
        }

        throw new RuntimeException("QuestionId or AnswerId required");
    }
}

