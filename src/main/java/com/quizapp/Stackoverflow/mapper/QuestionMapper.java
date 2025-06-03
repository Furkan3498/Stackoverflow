package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Tag;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

public class QuestionMapper {

    public static QuestionResponseDTO toDTO(Question question) {
        QuestionResponseDTO dto = new QuestionResponseDTO();
        dto.setId(question.getId());
        dto.setTitle(question.getTitle());
        dto.setContent(question.getContent());
        dto.setCreatedAt(question.getCreatedAt());
        dto.setVoteCount(question.getVotes().size());
        dto.setTags(question.getTags().stream().map(Tag::getName).collect(Collectors.toSet()));
        dto.setAuthor(UserMapper.toSummary(question.getUser()));
        dto.setAnswers(question.getAnswers().stream()
                .map(AnswerMapper::toDTO)
                .collect(Collectors.toList()));
        dto.setComments(question.getComments().stream()
                .map(CommentMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}
