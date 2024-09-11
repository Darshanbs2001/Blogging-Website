package com.blog.api.services;

import java.util.List;

import com.blog.api.dto.CategoryDto;

public interface CategoryService {
//create
CategoryDto createACategory(CategoryDto cat);
//update
CategoryDto updateCategory(CategoryDto cat,Long id);
// delete
void deleteCategory(Long id);
// get
CategoryDto getCategory(Long id);
// getAll
List<CategoryDto> getAll();
}
