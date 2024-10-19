package com.blog.api.dto;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class UserDto {
private Long id;
@NotNull
@NotEmpty(message = "The name cannot be empty")
@Size(min = 4,max=25 ,message="The name should be minimum of 5 characters long and cannot exceeds 25 characters in length")
private String name;
@NotEmpty(message="Field cannot be empty")
@Email(message="Please enter the valid email address")
private String email;
@NotEmpty(message="Field cannot be empty")
@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)(?=.*\\d)[A-Za-z\\d\\W]{8,14}",message="The password must meet all the criteria")
private String password;
@NotEmpty(message="Field cannot be empty")
@Length(max=50,min=5)
private String about;

private Set<RoleDto> roles=new HashSet<>();	
}
