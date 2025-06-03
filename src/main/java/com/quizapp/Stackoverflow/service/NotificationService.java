package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.model.Notification;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.NotificationRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import com.quizapp.Stackoverflow.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;
    private final UserService userService;

    public List<Notification> getUserNotifications() {
        User currentUser = userService.getCurrentUser();
        return notificationRepository.findByUser(currentUser);
    }

    public void createNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }
}
