package com.quizapp.Stackoverflow.controller;



import com.quizapp.Stackoverflow.model.QuestionDocument;
import com.quizapp.Stackoverflow.service.QuestionSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final QuestionSearchService searchService;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDocument>> searchQuestions(@RequestParam String keyword) {
        List<QuestionDocument> results = searchService.searchByTitle(keyword);
        return ResponseEntity.ok(results);
    }
}
