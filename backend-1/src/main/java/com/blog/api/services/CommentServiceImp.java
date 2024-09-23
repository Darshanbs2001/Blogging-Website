package com.blog.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.Exceptions.ResourceNotFound;
import com.blog.api.dto.CommentDto;
import com.blog.api.entities.Comment;
import com.blog.api.entities.Post;
import com.blog.api.repos.CommentRepo;
import com.blog.api.repos.PostRepo;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto,Long postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post", "post id", postId));
		Comment comment=this.modelMapper.map(commentDto,Comment.class);
		comment.setPost(post);
		Comment savedComment=this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment,CommentDto.class);
		
	}
	
	@Override
	public void deleteComment(Long commentId) {
		
		Comment com=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFound("Comment", "commentId", commentId));
		this.commentRepo.delete(com);
	}
	
	
}
