package com.quizapp.Stackoverflow.mapper;

import com.quizapp.Stackoverflow.dto.QuestionRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final TagRepository tagRepository;

    public QuestionResponseDTO toDTO(Question question) {
        QuestionResponseDTO dto = new QuestionResponseDTO();
        dto.setId(question.getId());
        dto.setTitle(question.getTitle());
        dto.setContent(question.getContent());
        dto.setAuthor(question.getAuthor().getUsername());
        dto.setTags(
                question.getTags().stream()
                        .map(Tag::getName)
                        .collect(Collectors.toList())
        );
        dto.setCreatedAt(question.getCreatedAt());
        return dto;
    }

    public Question toEntity(QuestionRequestDTO dto, User user) {
        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());
        question.setAuthor(user);
        question.setCreatedAt(LocalDateTime.now());

        List<Tag> tagEntities = dto.getTags() != null
                ? dto.getTags().stream()
                .map(name -> tagRepository.findByName(name).orElseGet(() -> {
                    Tag tag = new Tag();
                    tag.setName(name);
                    return tagRepository.save(tag);
                }))
                .collect(Collectors.toList())
                : new ArrayList<>();

        question.setTags(tagEntities);

        return question;
    }
}


