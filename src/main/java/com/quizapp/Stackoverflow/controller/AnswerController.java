package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.AnswerRequestDTO;
import com.quizapp.Stackoverflow.service.AnswerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/answers")



public class AnswerController {



    private final AnswerServiceImpl answerService;

    public AnswerController(AnswerServiceImpl answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/{questionId}")
    public ResponseEntity<?> addAnswer(@PathVariable Long questionId, @RequestBody AnswerRequestDTO answerDTO, Principal principal) {
        return ResponseEntity.ok(answerService.addAnswer(questionId, answerDTO, principal.getName()));
    }
}
