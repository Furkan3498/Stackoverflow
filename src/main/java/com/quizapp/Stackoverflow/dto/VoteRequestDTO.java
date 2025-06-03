package com.quizapp.Stackoverflow.dto;

import lombok.Data;

@Data
public class VoteRequestDTO {
    private Long questionId;
    private Long answerId;
    private boolean upvote;
}
