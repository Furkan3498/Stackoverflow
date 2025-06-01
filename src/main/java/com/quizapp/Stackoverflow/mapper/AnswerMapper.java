package com.quizapp.Stackoverflow.mapper;


import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public AnswerResponseDTO toDTO(Answer answer) {
        AnswerResponseDTO dto = new AnswerResponseDTO();
        dto.setId(answer.getId());
        dto.setContent(answer.getContent());
        dto.setUsername(answer.getUser().getUsername());
        dto.setVoteCount(answer.getVoteCount());
        dto.setCreatedAt(answer.getCreatedAt());
        return dto;
    }
}
