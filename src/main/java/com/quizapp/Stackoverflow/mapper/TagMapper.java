package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dto.TagRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.TagResponseDTO;
import com.quizapp.Stackoverflow.model.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public TagResponseDTO toDTO(Tag tag) {
        TagResponseDTO dto = new TagResponseDTO();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }

    public Tag toEntity(TagRequestDTO dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tag;
    }
}
