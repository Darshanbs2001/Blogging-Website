package com.blog.api.services;

import java.util.List;

import com.blog.api.dto.PostDto;
import com.blog.api.entities.Post;
import com.blog.api.utilities.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Long userId,Long categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Long postId);
	
	//delete
	void deletePost(Long postId);
	
	//get all posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy, String sortDir);
	
	//get single post
	PostDto getPostById(Long postId);
	
	//get all post by category
	List<PostDto> getPostByCategory(Long CategoryId);
	
	//get all post by user
	List<PostDto> getPostByUser(Long userId);
	
	//search post
	List<PostDto> searchPosts(String keyword);
}
