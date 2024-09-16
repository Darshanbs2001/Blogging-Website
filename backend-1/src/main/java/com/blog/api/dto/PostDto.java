package com.blog.api.dto;

import java.util.Date;

import com.blog.api.entities.Category;
import com.blog.api.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PostDto {

	private String title;
	
	private String content;

	private String ImageName;
	
	private Date addedDate;
	
	private Category category;
	
	private User user;
}
