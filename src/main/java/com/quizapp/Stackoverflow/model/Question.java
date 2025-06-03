package com.quizapp.Stackoverflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private User author;
    @ManyToMany
    private List<Tag> tags = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();
}
