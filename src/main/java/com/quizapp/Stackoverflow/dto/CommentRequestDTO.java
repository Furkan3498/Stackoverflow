package com.quizapp.Stackoverflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequestDTO {
    @NotBlank
    private String content;

    private Long questionId; // opsiyonel
    private Long answerId;   // opsiyonel
}