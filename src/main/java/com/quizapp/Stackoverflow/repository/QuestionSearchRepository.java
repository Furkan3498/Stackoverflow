package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.QuestionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QuestionSearchRepository extends ElasticsearchRepository<QuestionDocument,Long> {
}
