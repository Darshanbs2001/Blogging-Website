package com.blog.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
