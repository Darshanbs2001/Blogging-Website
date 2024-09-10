package com.blog.api.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class UserDto {
private UUID id;
@NotBlank(message = "The name cannot be empty")
@Size(min = 5,max=25 ,message="The name should be minimum of 5 characters long and cannot exceeds 25 characters in length")
private String name;
@Email(message="Please enter the valid email address")
private String email;
@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)(?=.*\\d)[A-Za-z\\d\\W]{8,14}",message="The password must meet all the criteria")
private String password;
@Length(max=50,min=5)
private String about;
}
