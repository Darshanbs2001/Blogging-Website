package com.blog.api.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.api.entities.Category;
import com.blog.api.entities.Comment;
import com.blog.api.entities.User;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Long postId;
	
	private String title;
	
	private String content;

	private String ImageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto>comments=new HashSet<>();
}
