package com.blog.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.dto.UserDto;
import com.blog.api.services.UserService;
import com.blog.api.utilities.ApiResponse;

import jakarta.validation.Valid;
@RequestMapping("/apis/users")
@RestController
public class UserController {
	@Autowired
	private UserService us;

@PostMapping("/")
public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
	
	UserDto user2=us.createUser(user);
	return new ResponseEntity<UserDto>(user2,HttpStatus.CREATED);
	
	
}
//This is done for just to see that jpa supports the findByEmail method
/*
 * @GetMapping("/signin") public ResponseEntity<UserDto> singIn(@RequestBody
 * UserDto user){
 * 
 * UserDto user1=us.findUserByEmail(user.getEmail()); return (new
 * ResponseEntity<UserDto>(user1,HttpStatus.FOUND));
 * 
 * }
 */
 @DeleteMapping("/{id}")
 public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id){
		 us.deleteUser(id);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.ACCEPTED);
 }
	    
 @GetMapping
 public ResponseEntity<List<UserDto>> getAllUsers(){
		 return new ResponseEntity<List<UserDto>>(us.getAllUsers(),HttpStatus.ACCEPTED);
	 
 }
 @PutMapping("/{id}")
 public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user,@PathVariable Long id)
 {
	 return new ResponseEntity<UserDto>(us.updateUser(user, id),HttpStatus.OK);
	 
 }
 @GetMapping("/{id}")
 public ResponseEntity<UserDto> getById(@PathVariable Long id){
	 return new ResponseEntity<UserDto>(us.getUserById(id),HttpStatus.FOUND);
 }
}
