package com.quizapp.Stackoverflow.controller;


import com.quizapp.Stackoverflow.service.VoteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<String> voteQuestion(@PathVariable Long questionId,
                                               @RequestParam boolean upvote,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        voteService.voteQuestion(questionId, upvote, userDetails.getUsername());
        return ResponseEntity.ok("Vote saved");
    }

    @PostMapping("/answer/{answerId}")
    public ResponseEntity<String> voteAnswer(@PathVariable Long answerId,
                                             @RequestParam boolean upvote,
                                             @AuthenticationPrincipal UserDetails userDetails) {
        voteService.voteAnswer(answerId, upvote, userDetails.getUsername());
        return ResponseEntity.ok("Vote saved");
    }
}
