package com.blog.api.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Long postId;
	@NotEmpty
	@Length(min = 3 ,max=50)
	private String title;
	@NotEmpty
	private String content;
	@URL
	private String ImageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto>comments=new HashSet<>();
}
