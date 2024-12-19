package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}
