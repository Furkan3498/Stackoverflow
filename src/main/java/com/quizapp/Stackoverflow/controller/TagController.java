package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.service.TagServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagServiceImpl tagService;

    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @GetMapping("/{tagName}/questions")
    public ResponseEntity<?> getQuestionsByTag(@PathVariable String tagName) {
        return ResponseEntity.ok(tagService.getQuestionsByTag(tagName));
    }
}
