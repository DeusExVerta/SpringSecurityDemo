package com.Howard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Howard.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
