package com.quizapp.Stackoverflow.dto;

import lombok.Data;


public class AnswerRequestDTO {
    private Long questionId;
    private String content;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
