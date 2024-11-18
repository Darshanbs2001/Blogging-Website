package com.blog.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.api.Exceptions.UserNameNotFoundException;
import com.blog.api.repos.UserRepo;

@Service
public class UserDetailsImplementation implements UserDetailsService {
 
	@Autowired
	UserRepo ur;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails userDetails=ur.findByEmail(email).orElseThrow(()->new UserNameNotFoundException("user not found"));
		
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.getPassword());
		System.out.println(userDetails.getAuthorities());
		return userDetails;
		/*
		 * Set<GrantedAuthority>authorities=user.getRoles().stream().map((role)->new
		 * SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet()); return
		 * new org.springframework.security.core.userdetails.User( user.getEmail(),
		 * user.getPassword(), authorities );
		 */
	}

}
