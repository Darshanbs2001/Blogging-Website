package com.blog.api.services;

import java.util.List;
import java.util.UUID;

import com.blog.api.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,UUID userid);
	List<UserDto> getAllUsers();
	void deleteUser(UUID id);
	UserDto getUserById(UUID id);
	//UserDto findUserByEmail(String email);

}
