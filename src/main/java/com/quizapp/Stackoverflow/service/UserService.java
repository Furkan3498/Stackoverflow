package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.UserLoginDTO;
import com.quizapp.Stackoverflow.dto.UserProfileDTO;
import com.quizapp.Stackoverflow.dto.UserRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.mapper.AnswerMapper;
import com.quizapp.Stackoverflow.mapper.QuestionMapper;
import com.quizapp.Stackoverflow.mapper.UserMapper;
import com.quizapp.Stackoverflow.model.Answer;
import com.quizapp.Stackoverflow.model.Question;
import com.quizapp.Stackoverflow.model.Role;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.AnswerRepository;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import com.quizapp.Stackoverflow.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.yaml.snakeyaml.tokens.Token.ID.Tag;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final QuestionMapper questionMapper;
    private final AnswerMapper answerMapper;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public List<QuestionResponseDTO> getUserQuestions(User user) {
        return questionRepository.findByAuthor(user).stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AnswerResponseDTO> getUserAnswers(User user) {
        return answerRepository.findByAuthor(user).stream()
                .map(answerMapper::toResponse)
                .collect(Collectors.toList());
    }

    public User register(UserRequestDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
