package com.quizapp.Stackoverflow.dtoResponse;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnswerResponseDTO {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}
