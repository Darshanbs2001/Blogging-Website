package com.blog.api.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoDetails implements UserDetails {

    private String username; // Changed from 'name' to 'username' for clarity
    private String password;
    private List<String> authorities;

    public UserInfoDetails(User userInfo) {
        this.username = userInfo.getEmail(); // Assuming 'name' is used as 'username'
        this.password = userInfo.getPassword();
        this.authorities = List.of(userInfo.getRoles()
        					.split(","));
        
              
                
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities
        		.stream()
        		.map(role->new SimpleGrantedAuthority(role))
        		.collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic if you need this
    }
}