package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.QuestionRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.mapper.QuestionMapper;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/questions")

public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO dto) {
        Question question = questionService.createQuestion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(questionMapper.toDTO(question));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        List<QuestionResponseDTO> response = questions.stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getById(id);
        return ResponseEntity.ok(questionMapper.toDTO(question));
    }
}
