package com.quizapp.Stackoverflow.config;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service

public class websocketService {


    private final SimpMessagingTemplate messagingTemplate;

    public websocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    public void sendToUser(String username, String message) {
        messagingTemplate.convertAndSendToUser(username, "/topic/notifications", message);
    }


}
