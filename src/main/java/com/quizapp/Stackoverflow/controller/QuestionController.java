package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.service.IQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {


    private final IQuestionService questionService;
    private final QuestionRepository questionRepository;

    public QuestionController(IQuestionService questionService, QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }


    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions(
            @RequestParam(required = false) String tag
    ) {
        List<Question> questions;

        if (tag != null) {
            questions = questionRepository.findByTagsNameIgnoreCase(tag);
        } else {
            questions = questionRepository.findAll();
        }

        return ResponseEntity.ok(
                questions.stream().map(mapper::toResponseDTO).collect(Collectors.toList())
        );

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
