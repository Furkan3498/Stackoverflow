package com.quizapp.Stackoverflow.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    @Enumerated(EnumType.STRING)
    private VoteType type;
}

