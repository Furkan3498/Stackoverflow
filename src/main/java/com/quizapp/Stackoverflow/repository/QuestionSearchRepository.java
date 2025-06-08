package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.QuestionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface QuestionSearchRepository extends ElasticsearchRepository<QuestionDocument,Long> {

    List<QuestionDocument> findByTitleContainingIgnoreCase(String title);
}
