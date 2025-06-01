package com.quizapp.Stackoverflow.controller;


import com.quizapp.Stackoverflow.service.VoteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteServiceImpl voteService;

    public VoteController(VoteServiceImpl voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/question/{questionId}")
    public ResponseEntity<?> voteQuestion(@PathVariable Long questionId, @RequestParam boolean upvote, Principal principal) {
        return ResponseEntity.ok(voteService.voteQuestion(questionId, upvote, principal.getName()));
    }

    @PostMapping("/answer/{answerId}")
    public ResponseEntity<?> voteAnswer(@PathVariable Long answerId, @RequestParam boolean upvote, Principal principal) {
        return ResponseEntity.ok(voteService.voteAnswer(answerId, upvote, principal.getName()));
    }
}
