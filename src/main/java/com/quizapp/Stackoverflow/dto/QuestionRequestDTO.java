package com.quizapp.Stackoverflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class QuestionRequestDTO {

        @NotBlank
        private String title;

        @NotBlank
        private String content;

        private Set<String> tags;
    } // sadece isimleri geliyor örn: ["java", "spring"]



