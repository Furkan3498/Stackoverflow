package com.quizapp.Stackoverflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class QuestionRequestDTO {
        private String title;
        private String content;
        private List<String> tags;
}
