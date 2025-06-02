package com.quizapp.Stackoverflow.service;

import com.quizapp.Stackoverflow.dto.UserProfileDTO;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.repository.AnswerRepository;
import com.quizapp.Stackoverflow.repository.QuestionRepository;
import com.quizapp.Stackoverflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public UserProfileDTO getProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        int questionCount = questionRepository.countByUser(user);
        int answerCount = answerRepository.countByUser(user);

        int questionVotes = questionRepository.findByUser(user).stream()
                .mapToInt(q -> q.getUpvotes().size()) // varsa set olarak tutuluyorsa
                .sum();

        int answerVotes = answerRepository.findByUser(user).stream()
                .mapToInt(a -> a.getUpvotes().size())
                .sum();

        int reputation = (questionVotes + answerVotes) * 10;

        return new UserProfileDTO(
                user.getUsername(),
                user.getEmail(),
                questionCount,
                answerCount,
                reputation
        );
    }
}
