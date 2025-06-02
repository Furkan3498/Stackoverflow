package com.quizapp.Stackoverflow.dtoResponse;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuestionResponseDTO {

    private Long id;
    private String title;
    private String content;
    private String username;
    private List<String> tags;
    private int voteCount;
    private LocalDateTime createdAt;


}
