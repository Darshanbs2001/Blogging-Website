package com.blog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/check")
	public ResponseEntity<String> verfiyUser(){
		return new ResponseEntity<String>("hi this is working",HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto login){
		return new ResponseEntity<LoginResponseDto>(us.loginUser(login),HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto user){
		return new ResponseEntity<UserDto>(us.createUser(user),HttpStatus.OK);
	}
	@PostMapping("/register/admin")
	public ResponseEntity<UserDto> registerAdmin(@Valid @RequestBody UserDto admin){
		return new ResponseEntity<UserDto>(us.createAdmin(admin),HttpStatus.OK);
	}
}
