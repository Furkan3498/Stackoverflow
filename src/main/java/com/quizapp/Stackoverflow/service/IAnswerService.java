package com.quizapp.Stackoverflow.service;

public interface IAnswerService {

    AnswerResponseDTO addAnswer(Long questionId, AnswerRequestDTO dto, String username);
    List<AnswerResponseDTO> getAnswersByQuestionId(Long questionId);
}
