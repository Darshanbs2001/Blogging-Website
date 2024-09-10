package com.blog.api.Exceptions;

public class NoUsersFound extends RuntimeException {
private String message;
public NoUsersFound(String message) {
	super(message);
	this.message=message;
	
}
}
