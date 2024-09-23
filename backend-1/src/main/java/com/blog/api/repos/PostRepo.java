package com.blog.api.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blog.api.entities.Category;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;

public interface PostRepo extends JpaRepository<Post, Long>{

	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
	
	List<Post>findByTitleContaining(String title);
	
	
}
