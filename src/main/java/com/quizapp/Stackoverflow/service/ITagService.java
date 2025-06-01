package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;

import java.util.List;

public interface ITagService {
    List<String> getAllTags();
    List<QuestionResponseDTO> getQuestionsByTag(String tagName);
}
