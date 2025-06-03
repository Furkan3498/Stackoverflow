package com.quizapp.Stackoverflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequestDTO {
    private Long questionId;
    private Long answerId;
    private String content;
}
