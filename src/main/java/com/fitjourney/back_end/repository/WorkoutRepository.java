package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Workout;

public interface WorkoutRepository extends JpaRepository <Workout, Long> {

}
