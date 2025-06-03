package com.quizapp.Stackoverflow.service;


import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.mapper.QuestionMapper;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TagService implements ITagService{
    private final TagRepository tagRepository;
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public TagService(TagRepository tagRepository, QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.tagRepository = tagRepository;
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<String> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(Tag::getName)
                .toList();
    }

    @Override
    public List<QuestionResponseDTO> getQuestionsByTag(String tagName) {
        Tag tag = tagRepository.findByName(tagName)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found"));
        return questionRepository.findAll()
                .stream()
                .filter(q -> q.getTags().contains(tag))
                .map(questionMapper::toDTO)
                .toList();
    }
}
