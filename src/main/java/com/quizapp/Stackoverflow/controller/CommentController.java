package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/question/{questionId}")
    public ResponseEntity<Void> commentToQuestion(@PathVariable Long questionId,
                                                  @RequestBody String content,
                                                  @AuthenticationPrincipal UserDetails userDetails) {
        commentService.commentToQuestion(questionId, content, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/answer/{answerId}")
    public ResponseEntity<Void> commentToAnswer(@PathVariable Long answerId,
                                                @RequestBody String content,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        commentService.commentToAnswer(answerId, content, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }
}
