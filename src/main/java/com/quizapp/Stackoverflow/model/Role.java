package com.quizapp.Stackoverflow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN
}
