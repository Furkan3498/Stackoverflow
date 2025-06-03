package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.AnswerRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.mapper.AnswerMapper;
import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.AnswerRepository;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserService userService;

    public Answer postAnswer(Long questionId, AnswerRequestDTO dto) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Answer answer = new Answer();
        answer.setContent(dto.getContent());
        answer.setQuestion(question);
        answer.setAuthor(userService.getCurrentUser());

        return answerRepository.save(answer);
    }
}

