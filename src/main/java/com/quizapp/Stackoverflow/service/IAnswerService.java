package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.AnswerRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;

import java.util.List;

public interface IAnswerService {

    AnswerResponseDTO addAnswer(Long questionId, AnswerRequestDTO dto, String username);
    List<AnswerResponseDTO> getAnswersByQuestionId(Long questionId);
}
