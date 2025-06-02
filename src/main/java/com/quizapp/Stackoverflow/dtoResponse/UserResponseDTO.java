package com.quizapp.Stackoverflow.dtoResponse;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserResponseDTO {
    private String username;
    private String email;
    private LocalDateTime createdAt;
}