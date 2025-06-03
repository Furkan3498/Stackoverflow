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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserService userService;

    public Comment commentOnQuestion(Long questionId, CommentRequestDTO dto) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setQuestion(question);
        comment.setAuthor(userService.getCurrentUser());

        return commentRepository.save(comment);
    }

    public Comment commentOnAnswer(Long answerId, CommentRequestDTO dto) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setAnswer(answer);
        comment.setAuthor(userService.getCurrentUser());

        return commentRepository.save(comment);
    }
}
