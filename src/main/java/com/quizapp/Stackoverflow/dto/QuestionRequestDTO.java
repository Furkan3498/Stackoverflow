package com.quizapp.Stackoverflow.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class QuestionRequestDTO {
    private String title;
    private String content;
    private Set<String> tags; // sadece isimleri geliyor örn: ["java", "spring"]
}
