package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.CommentRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.CommentResponseDTO;
import com.quizapp.Stackoverflow.mapper.CommentMapper;
import com.quizapp.Stackoverflow.model.Comment;
import com.quizapp.Stackoverflow.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")

public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping("/question/{questionId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CommentResponseDTO> commentOnQuestion(@PathVariable Long questionId,
                                                                @RequestBody CommentRequestDTO dto) {
        Comment comment = commentService.commentOnQuestion(questionId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentMapper.toResponse(comment));
    }

    @PostMapping("/answer/{answerId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CommentResponseDTO> commentOnAnswer(@PathVariable Long answerId,
                                                              @RequestBody CommentRequestDTO dto) {
        Comment comment = commentService.commentOnAnswer(answerId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentMapper.toResponse(comment));
    }
}

