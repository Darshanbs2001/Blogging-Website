package com.blog.api.Exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFound extends RuntimeException {
	private String resourceName;
	private String resourceField;
	private String id;
	public ResourceNotFound(String resourceName, String resourceField, String id) {
		super(String.format("%s doesnot have %s with %s", resourceName,resourceField,id));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.id = id;
	}
	

}
