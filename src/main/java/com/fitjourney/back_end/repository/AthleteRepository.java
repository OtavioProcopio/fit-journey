package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}
