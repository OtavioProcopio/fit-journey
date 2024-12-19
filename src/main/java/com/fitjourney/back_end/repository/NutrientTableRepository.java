package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.NutrientTable;

public interface NutrientTableRepository extends JpaRepository <NutrientTable, Long> {

}
