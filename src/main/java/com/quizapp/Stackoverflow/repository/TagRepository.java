package com.quizapp.Stackoverflow.repository;

import com.quizapp.Stackoverflow.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Optional<Tag> findByName(String name);
}
