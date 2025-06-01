package com.quizapp.Stackoverflow.controller;


import com.quizapp.Stackoverflow.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/question/{questionId}")
    public ResponseEntity<?> voteQuestion(@PathVariable Long questionId, @RequestParam boolean upvote) {
        return ResponseEntity.ok(voteService.voteQuestion(questionId, upvote));
    }

    @PostMapping("/answer/{answerId}")
    public ResponseEntity<?> voteAnswer(@PathVariable Long answerId, @RequestParam boolean upvote) {
        return ResponseEntity.ok(voteService.voteAnswer(answerId, upvote));
    }
}
