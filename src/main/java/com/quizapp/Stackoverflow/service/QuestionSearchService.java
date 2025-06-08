package com.quizapp.Stackoverflow.service;



import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.QuestionDocument;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.repository.QuestionSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class QuestionSearchService {

    private final QuestionSearchRepository searchRepository;

    public QuestionSearchService(QuestionSearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<QuestionDocument> searchByTitle(String keyword) {
        return searchRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public void indexQuestion(Question question) {
        QuestionDocument doc = new QuestionDocument();
        doc.setId(question.getId());
        doc.setTitle(question.getTitle());
        doc.setContent(question.getContent());
        doc.setAuthor(question.getAuthor().getUsername());
        doc.setTags(question.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        doc.setCreatedAt(question.getCreatedAt());

        searchRepository.save(doc);
    }


}
