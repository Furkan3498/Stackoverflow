package com.quizapp.Stackoverflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByQuestionId(Long questionId);
    List<Comment> findByAnswerId(Long answerId);
}