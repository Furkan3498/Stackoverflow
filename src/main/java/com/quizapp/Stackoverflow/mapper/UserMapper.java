package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dto.UserProfileDTO;
import com.quizapp.Stackoverflow.dto.UserRequestDTO;
import com.quizapp.Stackoverflow.dto.UserSummaryDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.UserResponseDTO;
import com.quizapp.Stackoverflow.model.Role;
import com.quizapp.Stackoverflow.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserMapper {

    public UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public UserSummaryDTO toUserSummaryDTO(User user) {
        UserSummaryDTO dto = new UserSummaryDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public UserProfileDTO toUserProfileDTO(User user, List<QuestionResponseDTO> questions, List<AnswerResponseDTO> answers) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setQuestions(questions);
        dto.setAnswers(answers);
        return dto;
    }

    public User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Hashing servis katmanında yapılmalı
        user.setRole(Role.ROLE_USER); // Varsayılan rol
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}



