package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Notification;
import com.quizapp.Stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByUser(User user);
}
