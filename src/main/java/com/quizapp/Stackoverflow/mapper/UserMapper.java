package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dto.UserProfileDTO;
import com.quizapp.Stackoverflow.dto.UserSummaryDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.UserResponseDTO;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public static UserSummaryDTO toSummary(User user) {
        UserSummaryDTO dto = new UserSummaryDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }
    public UserProfileDTO toProfileDTO(User user, List<QuestionResponseDTO> questions, List<AnswerResponseDTO> answers) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setQuestions(questions);
        dto.setAnswers(answers);
        return dto;
    }
}
