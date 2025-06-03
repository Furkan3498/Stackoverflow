package com.quizapp.Stackoverflow.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private String message;
    private boolean read;
    private LocalDateTime createdAt;
}
