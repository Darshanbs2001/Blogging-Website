package com.blog.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginDto {
@Email
private String email;
//@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?=.*\\\\d)[A-Za-z\\\\d\\\\W]{8,14}", message = "Sorry password needs to match all the conditions")
private String password;

}
