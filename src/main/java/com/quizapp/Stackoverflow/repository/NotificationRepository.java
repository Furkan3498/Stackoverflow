package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
