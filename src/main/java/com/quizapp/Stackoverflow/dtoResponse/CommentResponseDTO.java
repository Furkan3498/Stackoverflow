package com.quizapp.Stackoverflow.dtoResponse;

import com.quizapp.Stackoverflow.dto.UserSummaryDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDTO {
    private Long id;
    private String content;
    private UserSummaryDTO author;
    private LocalDateTime createdAt;
}