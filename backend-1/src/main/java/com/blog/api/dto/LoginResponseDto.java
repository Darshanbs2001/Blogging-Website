package com.blog.api.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
private String token;
private UserDto userdto;
public LoginResponseDto(String token, UserDto userdto) {
	
	this.token = token;
	this.userdto = userdto;
}

}
