package com.blog.api.services;

import java.util.List;

import com.blog.api.dto.PostDto;
import com.blog.api.entities.Post;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Long userId,Long categoryId);
	
	//update
	Post updatePost(Integer postDto,Integer postId);
	
	//delete
	void deletePsot(Integer postId);
	
	//get all posts
	List<Post> getAllPost();
	
	//get single post
	Post getPostById(Integer postId);
	
	//get all post by category
	List<Post> getPostByCategory(Integer CategoryId);
	
	//get all post by user
	List<Post> getPostByUser(Integer userId);
	
	//search post
	List<Post> searchPosts(String keyword);
}
