package com.quizapp.Stackoverflow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service

public class websocketService {


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendNotification(String username, String message) {
        messagingTemplate.convertAndSendToUser(username, "/topic/notifications", message);
    }
}
