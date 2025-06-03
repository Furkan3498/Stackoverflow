package com.quizapp.Stackoverflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    private User author;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Answer answer;
    private LocalDateTime createdAt = LocalDateTime.now();
}


