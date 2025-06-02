package com.quizapp.Stackoverflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
    private String username;
    private String email;
    private int questionCount;
    private int answerCount;
    private int totalReputation;
}