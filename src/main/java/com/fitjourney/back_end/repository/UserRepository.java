package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
 