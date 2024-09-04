package com.blog.api.services;

import java.util.List;

import com.blog.api.dto.UserDto;
import com.blog.api.entities.User;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,int userid);
	List<User> getAllUsers();
	void deleteUser(int id);
	UserDto getUserById(int id);

}
