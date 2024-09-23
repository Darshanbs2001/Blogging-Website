package com.blog.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long>{

}
