package com.blog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.dto.CommentDto;
import com.blog.api.entities.Comment;
import com.blog.api.services.CommentService;
import com.blog.api.utilities.ApiResponse;

@RestController
@RequestMapping("/apis/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto comment,@PathVariable Long postId){
		
	CommentDto createComment=this.commentService.createComment(comment, postId);
	return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse>deleteComment(@RequestBody Long commentId){
		
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted successfully!!",true),HttpStatus.CREATED);
	
	}
}
