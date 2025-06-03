package com.quizapp.Stackoverflow.dtoResponse;

import com.quizapp.Stackoverflow.dto.UserSummaryDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class QuestionResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<String> tags;
    private LocalDateTime createdAt;
}
