package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}