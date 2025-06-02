package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dto.UserSummaryDTO;
import com.quizapp.Stackoverflow.dtoResponse.UserResponseDTO;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.stereotype.Component;

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
        return dto;
    }
}
