package com.quizapp.Stackoverflow.mapper;


import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.model.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public AnswerResponseDTO toResponse(Answer answer) {
        AnswerResponseDTO dto = new AnswerResponseDTO();
        dto.setId(answer.getId());
        dto.setContent(answer.getContent());
        dto.setAuthor(answer.getAuthor().getUsername());
        dto.setCreatedAt(answer.getCreatedAt());
        return dto;
    }
}
