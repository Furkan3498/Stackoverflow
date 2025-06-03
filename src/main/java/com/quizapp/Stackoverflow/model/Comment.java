package com.quizapp.Stackoverflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    private LocalDateTime createdAt = LocalDateTime.now();
}


