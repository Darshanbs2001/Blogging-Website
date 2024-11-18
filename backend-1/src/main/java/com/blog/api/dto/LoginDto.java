package com.blog.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginDto {
@Email
@NotBlank
private String email;
@NotBlank
@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)(?=.*\\d)[A-Za-z\\d\\W]{8,14}",message="The password must meet all the criteria")
private String password;

}
