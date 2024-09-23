package com.blog.api.services;

import com.blog.api.dto.CommentDto;

public interface CommentService {

	  CommentDto createComment(CommentDto commentDto,Long postId);
		  
		  void deleteComment(Long commentId);
}
