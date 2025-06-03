package com.quizapp.Stackoverflow.dtoResponse;

import com.quizapp.Stackoverflow.dto.UserSummaryDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class QuestionResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int voteCount;
    private Set<String> tags;
    private UserSummaryDTO author;
    private List<AnswerResponseDTO> answers;
    private List<CommentResponseDTO> comments;
}
