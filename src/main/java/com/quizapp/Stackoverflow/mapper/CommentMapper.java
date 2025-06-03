package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dtoResponse.CommentResponseDTO;
import com.quizapp.Stackoverflow.model.Comment;

public class CommentMapper {

    public static CommentResponseDTO toDTO(Comment comment) {
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setAuthor(UserMapper.toSummary(comment.getUser()));
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }
}
