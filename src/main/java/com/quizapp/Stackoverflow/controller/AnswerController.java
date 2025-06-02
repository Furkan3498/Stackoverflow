package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.AnswerRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.service.AnswerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<AnswerResponseDTO> addAnswer(@PathVariable Long questionId,
                                                       @RequestBody AnswerRequestDTO dto,
                                                       @AuthenticationPrincipal UserDetails userDetails) {
        AnswerResponseDTO response = answerService.addAnswer(questionId, dto, userDetails.getUsername());
        return ResponseEntity.ok(response);
    }
}
