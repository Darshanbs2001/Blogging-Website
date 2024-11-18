package com.blog.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.api.Exceptions.NoUsersFound;
import com.blog.api.Exceptions.ResourceNotFound;
import com.blog.api.Exceptions.UserNameNotFoundException;
import com.blog.api.config.AppConstants;
import com.blog.api.dto.LoginDto;
import com.blog.api.dto.LoginResponseDto;
import com.blog.api.dto.UserDto;
import com.blog.api.entities.Role;
import com.blog.api.entities.User;
import com.blog.api.repos.RoleRepo;
import com.blog.api.repos.UserRepo;
import com.blog.api.security.config.JwtService;
@Service
class UserServiceImp implements UserService{
	@Autowired
	private UserRepo ur;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private JwtService jwts;
	@Autowired
	private UserDetailsImplementation authService;
	@Autowired
	private RoleRepo rr;
	//it is done for testing purpose only
	/*
	 * @Override public UserDto findUserByEmail(String email) { User
	 * user=ur.findByEmail(email).orElseThrow(()->new
	 * ResourceNotFound("user","email",email)); return convertToDto(user); }
	 */

	@Override
	public UserDto createUser(UserDto user) {
		
		
		User saveUser=new User();
		saveUser.setAbout(user.getAbout());
		saveUser.setEmail(user.getEmail());
		saveUser.setAbout(user.getAbout());
		saveUser.setName(user.getName());
		saveUser.setPassword(encoder.encode(user.getPassword()));
		Role role=rr.findById(AppConstants.NORMAL_USER).orElseThrow(()->new ResourceNotFound("sorry could not find any roles please try again later","role",null));
		saveUser.getRoles().add(role);
	   // saveUser.setRoles(user.getRoles());
	   return userToDto( ur.save(saveUser));
	   
	} 

	@Override
	public UserDto updateUser(UserDto user, Long userid) {
		User dbuser=ur.findById(userid).orElseThrow(()->new ResourceNotFound("User","Id",userid));
		dbuser.setName(user.getName());
		dbuser.setEmail(user.getEmail());
		dbuser.setPassword(encoder.encode(user.getPassword()));
		dbuser.setAbout(user.getAbout());
		return(userToDto(ur.save(dbuser)));
	}
	@Override
	
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=ur.findAll();
		if(users.isEmpty()) {
			throw new NoUsersFound("There are no users to be listed");
		}
		return users.stream().map(user->userToDto(user)).collect(Collectors.toList());
	
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		User user=ur.findById(id).orElseThrow(()->new ResourceNotFound("User","Id",id));
		System.out.println(user);
		if(user!=null) {
			ur.delete(user);
		}
		
		
	}

	@Override
	public UserDto getUserById(Long id) {
		User user=ur.findById(id).orElseThrow(()->new ResourceNotFound("User","Id",id));
		return mapper.map(user,UserDto.class);
	}
	
	public User dtoToUser(UserDto u) {
		User user=this.mapper.map(u, User.class);
		return user;
	}
	
	public UserDto userToDto(User u) {
		UserDto user=this.mapper.map(u, UserDto.class);
		return user;
	}

	@Override
	public LoginResponseDto loginUser(LoginDto login) {
		// TODO Auto-generated method stub
		User u=ur.findByEmail(login.getEmail()).orElseThrow(()->new UserNameNotFoundException("Invalid user"));
		Authentication auth=manager.authenticate(new UsernamePasswordAuthenticationToken(
				login.getEmail(),login.getPassword()
				));
		String token;
		if(auth.isAuthenticated()) {
			token= jwts.generateToken(authService.loadUserByUsername(login.getEmail()));
		   
		}
		else {
			throw new UserNameNotFoundException("Invalid user");
		}
		return new LoginResponseDto(token, userToDto(u));
	}
}
