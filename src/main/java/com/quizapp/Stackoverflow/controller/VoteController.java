package com.quizapp.Stackoverflow.controller;


import com.quizapp.Stackoverflow.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")

public class VoteController {
    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/question/{questionId}/up")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> upvoteQuestion(@PathVariable Long questionId) {
        voteService.upvoteQuestion(questionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/answer/{answerId}/down")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> downvoteAnswer(@PathVariable Long answerId) {
        voteService.downvoteAnswer(answerId);
        return ResponseEntity.ok().build();
    }
}

