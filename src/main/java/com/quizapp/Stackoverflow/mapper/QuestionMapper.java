package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Tag;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestionMapper {
    public QuestionResponseDTO toResponse(Question question) {
        QuestionResponseDTO dto = new QuestionResponseDTO();
        dto.setId(question.getId());
        dto.setTitle(question.getTitle());
        dto.setContent(question.getContent());
        dto.setAuthor(question.getAuthor().getUsername());
        dto.setTags(question.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        dto.setCreatedAt(question.getCreatedAt());
        return dto;
    }
}
