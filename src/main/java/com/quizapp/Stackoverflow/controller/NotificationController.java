package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dtoResponse.NotificationResponseDTO;
import com.quizapp.Stackoverflow.mapper.NotificationMapper;
import com.quizapp.Stackoverflow.model.Notification;
import com.quizapp.Stackoverflow.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<NotificationResponseDTO>> getMyNotifications() {
        List<Notification> notifications = notificationService.getUserNotifications();
        List<NotificationResponseDTO> response = notifications.stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
