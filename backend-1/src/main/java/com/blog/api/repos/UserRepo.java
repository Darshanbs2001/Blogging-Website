package com.blog.api.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
 	
 Optional<User> findByEmail(String email);
}
