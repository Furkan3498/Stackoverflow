package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.AnswerRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.mapper.AnswerMapper;
import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    @PostMapping("/question/{questionId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<AnswerResponseDTO> postAnswer(@PathVariable Long questionId,
                                                        @RequestBody AnswerRequestDTO dto) {
        Answer answer = answerService.postAnswer(questionId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(answerMapper.toResponse(answer));
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<AnswerResponseDTO>> getAnswersByQuestion(@PathVariable Long questionId) {
        List<Answer> answers = answerService.getAnswersByQuestion(questionId);
        List<AnswerResponseDTO> response = answers.stream()
                .map(answerMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
