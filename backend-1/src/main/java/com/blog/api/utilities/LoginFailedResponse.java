package com.blog.api.utilities;

import lombok.Data;

@Data
public class LoginFailedResponse {
private String message;
private String result;
private boolean status;
public LoginFailedResponse(String message, String result, boolean status) {
	super();
	this.message = message;
	this.result = result;
	this.status = status;
}
}
