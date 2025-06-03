package com.quizapp.Stackoverflow.service;


import com.quizapp.Stackoverflow.dto.CommentRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.CommentResponseDTO;
import com.quizapp.Stackoverflow.mapper.CommentMapper;
import com.quizapp.Stackoverflow.model.Answer;

import com.quizapp.Stackoverflow.model.Comment;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.AnswerRepository;
import com.quizapp.Stackoverflow.repository.CommentRepository;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;




    public CommentService(CommentRepository commentRepository, UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }



    public CommentResponseDTO addComment(CommentRequestDTO dto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setUser(user);
        comment.setCreatedAt(LocalDateTime.now());

        if (dto.getQuestionId() != null) {
            Question question = questionRepository.findById(dto.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            comment.setQuestion(question);
        } else if (dto.getAnswerId() != null) {
            Answer answer = answerRepository.findById(dto.getAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            comment.setAnswer(answer);
        } else {
            throw new IllegalArgumentException("Either questionId or answerId must be provided");
        }

        Comment savedComment = commentRepository.save(comment);
        return CommentMapper.toDTO(savedComment);
    }
}
