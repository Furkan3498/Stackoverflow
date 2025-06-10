package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.QuestionRequestDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final UserService userService;
    private final QuestionSearchService questionSearchService;

    public QuestionService(QuestionRepository questionRepository, TagRepository tagRepository, UserService userService, QuestionSearchService questionSearchService) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
        this.userService = userService;
        this.questionSearchService = questionSearchService;
    }

    public Question createQuestion(QuestionRequestDTO dto) {
        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());
        question.setAuthor(userService.getCurrentUser());

        List<Tag> tags = dto.getTags().stream()
                .map(name -> tagRepository.findByName(name)
                        .orElseGet(() -> tagRepository.save(new Tag(null, name))))
                .collect(Collectors.toList());
        question.setTags(tags);

        Question saved = questionRepository.save(question);


        questionSearchService.indexQuestion(saved);

        return saved;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + id));
    }
}
