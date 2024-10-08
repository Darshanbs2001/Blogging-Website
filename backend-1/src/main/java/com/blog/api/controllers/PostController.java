package com.blog.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.api.config.AppConstants;
import com.blog.api.dto.PostDto;
import com.blog.api.services.FileService;
import com.blog.api.services.PostService;
import com.blog.api.utilities.ApiResponse;
import com.blog.api.utilities.PostResponse;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/apis/")

public class PostController {
	 
	@Autowired
	private PostService postService;
	
	@Autowired
	 private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//create
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto>createPost(
			@Valid @RequestBody PostDto postDto,
			@PathVariable Long userId,
			@PathVariable Long categoryId
			){
		
		PostDto createPost=postService.createPost(postDto,userId,categoryId);
		
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	//get user

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>>getPostsByUser(@PathVariable Long userId){
		
		List<PostDto>posts=this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	//get by category
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>>getPostsByCategory(@PathVariable Long categoryId){
		
		List<PostDto>posts=this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	// get all posts
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse>getAllPost(
			@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required=false)int pageNumber,
			@RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required=false)int pageSize,
		@RequestParam(value="sortBy",defaultValue=AppConstants.SORT_BY,required=false)String sortBy,
		@RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR,required=false)String sortDir){
		
		PostResponse postResponse= this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	
	//get post details by id
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Long postId){
		
		PostDto postDto=this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	//post delete
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Long postId) {
		
		this.postService.deletePost(postId);
		
		return new ApiResponse("post is succesfully deleted !!",true);
	}
	
	//update post
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable Long postId) {
		
		PostDto updatePost=this.postService.updatePost(postDto,postId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		}
	
	//search
	
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>>searchPostByTitle(
		@PathVariable("keywords")String keywords){
		
		List<PostDto>result=this.postService.searchPosts(keywords);
		
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
	}
	
	//post image upload
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto>uploadPostImage(
		@RequestParam("image")MultipartFile image,
		@PathVariable Long postId)throws IOException{
		
		PostDto postDto=this.postService.getPostById(postId);
		String filename=this.fileService.uploadImage(path, image);
		postDto.setImageName(filename);
		PostDto updatePost=this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	//method to serve files

	@GetMapping(value="/post/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName")String imageName,
			HttpServletResponse response)throws IOException{
		
		InputStream resource=this.fileService.getResource(path,imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource,response.getOutputStream());
	}
}
