package com.quizapp.Stackoverflow.dto;

import lombok.Data;

@Data
public class AnswerRequestDTO {
    private Long questionId;
    private String content;
}
