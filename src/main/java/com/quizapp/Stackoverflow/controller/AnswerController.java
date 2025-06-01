package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor


public class AnswerController {


    private final AnswerService answerService;

    @PostMapping("/{questionId}")
    public ResponseEntity<?> addAnswer(@PathVariable Long questionId, @RequestBody Answer answer, Principal principal) {
        return ResponseEntity.ok(answerService.addAnswer(questionId, answer, principal.getName()));
    }
}
