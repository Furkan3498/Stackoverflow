package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.QuestionRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.service.IQuestionService;
import com.quizapp.Stackoverflow.service.QuestionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {


    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionResponseDTO> addQuestion(@RequestBody QuestionRequestDTO dto,
                                                           @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(questionService.createQuestion(dto, userDetails.getUsername()));
    }

}
