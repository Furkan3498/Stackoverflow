package com.quizapp.Stackoverflow.controller;



import com.quizapp.Stackoverflow.model.QuestionDocument;
import com.quizapp.Stackoverflow.service.QuestionSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/search")
public class SearchController {

    private final QuestionSearchService searchService;

    public SearchController(QuestionSearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDocument>> searchQuestions(@RequestParam String keyword) {
        List<QuestionDocument> results = searchService.searchByTitle(keyword);
        return ResponseEntity.ok(results);
    }
}
