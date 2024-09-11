package com.blog.api.services;

import java.util.List;

import com.blog.api.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Long userid);
	List<UserDto> getAllUsers();
	void deleteUser(Long id);
	UserDto getUserById(Long id);
	//UserDto findUserByEmail(String email);

}
