package com.blog.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>
{
	
}