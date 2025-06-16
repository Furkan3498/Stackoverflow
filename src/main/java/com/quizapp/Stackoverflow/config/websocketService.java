package com.quizapp.Stackoverflow.config;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service

public class websocketService {


    private final SimpMessagingTemplate messaging;

    public websocketService(SimpMessagingTemplate messaging) {
        this.messaging = messaging;
    }

    public void sendToUser(String username, String message) {
        messaging.convertAndSendToUser(username, "/topic/notifications", message);
    }


}
