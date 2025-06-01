package com.quizapp.Stackoverflow.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Answer     {

    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String content;

    private LocalDateTime createdAt;
    private int voteCount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(Long id, String content, LocalDateTime createdAt, int voteCount, User user, Question question) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.voteCount = voteCount;
        this.user = user;
        this.question = question;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", voteCount=" + voteCount +
                ", user=" + user +
                ", question=" + question +
                '}';
    }
}
