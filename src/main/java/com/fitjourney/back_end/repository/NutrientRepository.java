package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Nutrient;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {

}
