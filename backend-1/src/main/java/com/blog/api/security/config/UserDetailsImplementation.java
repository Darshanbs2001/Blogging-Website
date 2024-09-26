package com.blog.api.security.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blog.api.entities.User;
import com.blog.api.repos.UserRepo;

public class UserDetailsImplementation implements UserDetailsService {
 
	@Autowired
	UserRepo ur;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=ur.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User doesnot exists with the given email"));
		Set<GrantedAuthority>authorities=user.getRoles().stream().map((role)->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
      return org.springframework.boot.autoconfigure.security.SecurityProperties.User(
    		  email,
    		  user.getPassword(),
    		  authorities
    		  );
	}

}
