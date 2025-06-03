package com.quizapp.Stackoverflow.service;


import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.mapper.QuestionMapper;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag createTag(TagRequestDTO dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
