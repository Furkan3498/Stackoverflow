package com.quizapp.Stackoverflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {
    private String username;
    private String password;
}
