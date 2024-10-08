package com.blog.api.Exceptions;

public class UserNameNotFoundException extends RuntimeException {
private String message;

public UserNameNotFoundException(String message) {
	super();
	this.message = message;
}


}
