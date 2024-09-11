package com.blog.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{
 
}
