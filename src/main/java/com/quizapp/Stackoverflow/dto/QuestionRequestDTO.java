package com.quizapp.Stackoverflow.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionRequestDTO {
    private String title;
    private String content;
    private List<String> tagNames;
}
