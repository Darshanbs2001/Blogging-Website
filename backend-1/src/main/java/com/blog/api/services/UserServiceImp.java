package com.blog.api.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.Exceptions.NoUsersFound;
import com.blog.api.Exceptions.ResourceNotFound;
import com.blog.api.dto.UserDto;
import com.blog.api.entities.User;
import com.blog.api.repos.UserRepo;
@Service
class UserServiceImp implements UserService{
	@Autowired
	private UserRepo ur;
	//it is done for testing purpose only
	/*
	 * @Override public UserDto findUserByEmail(String email) { User
	 * user=ur.findByEmail(email).orElseThrow(()->new
	 * ResourceNotFound("user","email",email)); return convertToDto(user); }
	 */

	@Override
	public UserDto createUser(UserDto user) {
	    
		UserDto user1=convertToDto(ur.save(convertToUser(user)));
	   return user1;
	}

	@Override
	public UserDto updateUser(UserDto user, UUID userid) {
		User dbuser=ur.findById(userid).orElseThrow(()->new ResourceNotFound("User","Id",String.valueOf(userid)));
		dbuser.setName(user.getName());
		dbuser.setEmail(user.getEmail());
		dbuser.setPassword(user.getPassword());
		dbuser.setAbout(user.getAbout());
		return(convertToDto(ur.save(dbuser)));
	}
	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=ur.findAll();
		if(users.isEmpty()) {
			throw new NoUsersFound("There are no users to be listed");
		}
		return users.stream().map(user->convertToDto(user)).collect(Collectors.toList());
	
	}

	@Override
	public void deleteUser(UUID id) {
		// TODO Auto-generated method stub
		User user=ur.findById(id).orElseThrow(()->new ResourceNotFound("User","Id",String.valueOf(id)));
		System.out.println(user);
		if(user!=null) {
			ur.delete(user);
		}
		
		
	}

	@Override
	public UserDto getUserById(UUID id) {
		User user=ur.findById(id).orElseThrow(()->new ResourceNotFound("User","Id",String.valueOf(id)));
		return convertToDto(user);
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
    private UserDto convertToDto(User user) {
    	UserDto newUser=new UserDto();
    	newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setAbout(user.getAbout());
		return newUser;
    }
}
