package com.quizapp.Stackoverflow.service;

public interface IVoteService {
    String voteQuestion(Long questionId, boolean upvote, String username);
    String voteAnswer(Long answerId, boolean upvote, String username);
}
