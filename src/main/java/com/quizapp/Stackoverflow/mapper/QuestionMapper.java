package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Tag;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    public QuestionResponseDTO toDTO(Question question) {
        QuestionResponseDTO dto = new QuestionResponseDTO();
        dto.setId(question.getId());
        dto.setTitle(question.getTitle());
        dto.setContent(question.getContent());
        dto.setUsername(question.getUser().getUsername());
        dto.setTags(question.getTags().stream().map(Tag::getName).toList());
        dto.setVoteCount(question.getVoteCount());
        dto.setCreatedAt(question.getCreatedAt());
        return dto;
    }
}
