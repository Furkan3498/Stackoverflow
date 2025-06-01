package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.QuestionRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;

import java.util.List;

public interface IQuestionService {

    QuestionResponseDTO createQuestion(QuestionRequestDTO dto, String username);
    List<QuestionResponseDTO> getAllQuestions();
    QuestionResponseDTO getQuestionById(Long id);
}
