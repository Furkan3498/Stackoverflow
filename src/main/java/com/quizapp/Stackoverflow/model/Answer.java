package com.quizapp.Stackoverflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity


public class Answer {
    @Id @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User author;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Answer(Long id, String content, Question question, User author, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.author = author;
        this.createdAt = createdAt;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

