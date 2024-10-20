package com.blog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.dto.LoginDto;
import com.blog.api.dto.LoginResponseDto;
import com.blog.api.dto.UserDto;
import com.blog.api.services.UserService;

import jakarta.validation.Valid;
@RequestMapping("/apis")
@RestController
public class AuthController {
	@Autowired
	private UserService us;
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto login){
		return new ResponseEntity<LoginResponseDto>(new LoginResponseDto(us.loginUser(login),"logged in successfully"),HttpStatus.FOUND);
	}
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto user){
		return new ResponseEntity<UserDto>(us.createUser(user),HttpStatus.OK);
	}
}
