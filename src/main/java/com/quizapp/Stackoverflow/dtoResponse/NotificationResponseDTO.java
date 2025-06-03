package com.quizapp.Stackoverflow.dtoResponse;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {
    private Long id;
    private String message;
    private LocalDateTime createdAt;
}