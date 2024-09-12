package com.blog.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDto {
 private Long id;
 @NotEmpty(message="field cannot be empty")
 @Size(min=5,max=30,message="The title needs to atleast 5 character long and most not exceed 30 characters in length")
 private String categoryTitle;
 
 private String categoryDescription;
}
