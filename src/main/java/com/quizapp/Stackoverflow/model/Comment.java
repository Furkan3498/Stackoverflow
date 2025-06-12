package com.quizapp.Stackoverflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity

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

    public Comment() {
    }

    public Comment(Long id, String content, User author, Question question, Answer answer, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.question = question;
        this.answer = answer;
        this.createdAt = createdAt;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


