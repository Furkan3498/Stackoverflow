package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dtoResponse.NotificationResponseDTO;
import com.quizapp.Stackoverflow.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public NotificationResponseDTO toDTO(Notification notification) {
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setId(notification.getId());
        dto.setMessage(notification.getMessage());
        dto.setCreatedAt(notification.getCreatedAt());
        return dto;
    }
}
