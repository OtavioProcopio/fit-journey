package com.fitjourney.back_end.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitjourney.back_end.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, UUID> {
}



 