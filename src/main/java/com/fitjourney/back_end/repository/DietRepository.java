package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Diet;

public interface DietRepository extends JpaRepository <Diet, Long> {

}
