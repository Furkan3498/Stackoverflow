package com.quizapp.Stackoverflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User author;
    private LocalDateTime createdAt = LocalDateTime.now();
}

