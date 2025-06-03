package com.quizapp.Stackoverflow.dto;

import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserProfileDTO {
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private List<QuestionResponseDTO> questions;
    private List<AnswerResponseDTO> answers;
}