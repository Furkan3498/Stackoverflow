package com.quizapp.Stackoverflow.dtoResponse;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnswerResponseDTO { private Long id;
    private String content;
    private String username;
    private int voteCount;
    private LocalDateTime createdAt;
}
