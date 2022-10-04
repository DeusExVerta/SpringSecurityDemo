package com.Howard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Howard.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
