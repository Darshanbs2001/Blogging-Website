package com.blog.api.Exceptions;

import lombok.Data;

@Data
public class UserNameNotFoundException extends RuntimeException {
private String message;

public UserNameNotFoundException(String message) {
	
	this.message = message;
}


}
