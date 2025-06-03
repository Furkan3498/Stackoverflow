package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    private final TagMapper tagMapper;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TagResponseDTO> createTag(@RequestBody TagRequestDTO dto) {
        Tag tag = tagService.createTag(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tagMapper.toDTO(tag));
    }

    @GetMapping
    public ResponseEntity<List<TagResponseDTO>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        List<TagResponseDTO> response = tags.stream().map(tagMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}

