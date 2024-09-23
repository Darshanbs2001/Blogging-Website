package com.blog.api.Exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFound extends RuntimeException {
	private String resourceName;
	private String resourceField;
	private Long id;
	public ResourceNotFound(String resourceName, String resourceField, Long postId) {
		super(String.format("%s doesnot have %s with %d", resourceName,resourceField,postId));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.id = postId;
	}
	

}
