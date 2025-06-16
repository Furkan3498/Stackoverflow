package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dto.CommentRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.CommentResponseDTO;
import com.quizapp.Stackoverflow.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public static CommentResponseDTO toResponse(Comment comment) {
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setAuthor(comment.getAuthor().getUsername());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }

    public Comment toEntity(CommentRequestDTO dto) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        return comment;
    }
}
