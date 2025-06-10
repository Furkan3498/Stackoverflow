package com.quizapp.Stackoverflow.service;


import com.quizapp.Stackoverflow.dto.TagRequestDTO;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service

public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(TagRequestDTO dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
