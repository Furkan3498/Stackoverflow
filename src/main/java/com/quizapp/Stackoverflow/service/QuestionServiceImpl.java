package com.quizapp.Stackoverflow.service;


import com.quizapp.Stackoverflow.dto.QuestionRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.mapper.QuestionMapper;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Tag;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.TagRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements IQuestionService{

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final QuestionMapper questionMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository, TagRepository tagRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.questionMapper = questionMapper;
    }

    public QuestionResponseDTO createQuestion(QuestionRequestDTO dto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());
        question.setUser(user);

        Set<Tag> tagEntities = dto.getTags().stream()
                .map(name -> tagRepository.findByName(name)
                        .orElseGet(() -> tagRepository.save(new Tag(null, name, new HashSet<>())))
                ).collect(Collectors.toSet());

        question.setTags(tagEntities);

        questionRepository.save(question);

        return mapper.toResponseDTO(question);
    }

    @Override
    public List<QuestionResponseDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponseDTO getQuestionById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
        return questionMapper.toDTO(question);
    }
}
