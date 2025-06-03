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
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public Comment addComment(CommentRequestDTO dto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setAuthor(user);

        if (dto.getQuestionId() != null) {
            Question question = questionRepository.findById(dto.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            comment.setQuestion(question);
        } else if (dto.getAnswerId() != null) {
            Answer answer = answerRepository.findById(dto.getAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            comment.setAnswer(answer);
        } else {
            throw new RuntimeException("Question or Answer ID is required");
        }

        return commentRepository.save(comment);
    }
}
