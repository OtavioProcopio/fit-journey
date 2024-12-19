package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Meal;

public interface MealRepository extends JpaRepository <Meal, Long> {

}
