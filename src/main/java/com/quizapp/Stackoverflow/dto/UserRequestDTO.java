package com.quizapp.Stackoverflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String username;
    private String email;
    private String password;
}
