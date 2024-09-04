package com.blog.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.api.dto.UserDto;
import com.blog.api.entities.User;
import com.blog.api.repos.UserRepo;

public class UserServiceImp implements UserService{
	@Autowired
	private UserRepo ur;

	@Override
	public UserDto createUser(UserDto user) {
	    try {
		ur.save(convertToUser(user));
	    }
	    catch(Exception e) {
	    	throw e;
	    }
		return user;
	}

	@Override
	public UserDto updateUser(UserDto user, int userid) {
		Optional<User> dbuser=ur.findById(userid);
		dbuser=
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	private User convertToUser(UserDto user) {
		User newUser=new User();
		newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setAbout(user.getAbout());
		return newUser;
	}

}
