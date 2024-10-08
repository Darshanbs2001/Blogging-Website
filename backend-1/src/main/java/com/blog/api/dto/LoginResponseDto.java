package com.blog.api.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
private String token;
private String message;
public LoginResponseDto(String token, String message) {
	super();
	this.token = token;
	this.message = message;
}

}
