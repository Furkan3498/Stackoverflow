package com.quizapp.Stackoverflow.controller;

import com.quizapp.Stackoverflow.dto.UserProfileDTO;
import com.quizapp.Stackoverflow.dto.UserRequestDTO;
import com.quizapp.Stackoverflow.dtoResponse.AnswerResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.QuestionResponseDTO;
import com.quizapp.Stackoverflow.dtoResponse.UserResponseDTO;
import com.quizapp.Stackoverflow.mapper.UserMapper;
import com.quizapp.Stackoverflow.model.User;
import com.quizapp.Stackoverflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserProfileDTO> getProfile() {
        User user = userService.getCurrentUser();
        List<QuestionResponseDTO> questions = userService.getUserQuestions(user);
        List<AnswerResponseDTO> answers = userService.getUserAnswers(user);
        return ResponseEntity.ok(userMapper.toUserProfileDTO(user, questions, answers));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO dto) {
        User user = userService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toUserResponseDTO(user));
    }
}
