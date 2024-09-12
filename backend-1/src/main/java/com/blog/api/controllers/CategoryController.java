package com.blog.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.dto.CategoryDto;
import com.blog.api.services.CategoryService;
import com.blog.api.utilities.ApiResponse;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/apis/categories")
public class CategoryController {
 @Autowired
 private CategoryService cs;
 
 //create a category
 @PostMapping
 public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cat){
	 return new ResponseEntity<CategoryDto>(cs.createACategory(cat),HttpStatus.CREATED);
 }
 //display all category
 @GetMapping
 public ResponseEntity<List<CategoryDto>> getAllCategory(){
	 return new ResponseEntity<List<CategoryDto>>(cs.getAll(),HttpStatus.FOUND);
 }
 @GetMapping("/{id}")
 public ResponseEntity<CategoryDto> getACategory(@PathVariable Long id){
	 return new ResponseEntity<CategoryDto>(cs.getCategory(id),HttpStatus.FOUND);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<ApiResponse> deleteACategory(@PathVariable Long id){
	  cs.deleteCategory(id);
	 return new ResponseEntity<ApiResponse>(new ApiResponse("deleted successfully",true),HttpStatus.ACCEPTED);
 }
 @PutMapping("/{id}")
 public ResponseEntity<CategoryDto> updateACategory(@PathVariable Long id, @Valid @RequestBody CategoryDto cat){
	 return new ResponseEntity<CategoryDto>(cs.updateCategory(cat, id),HttpStatus.ACCEPTED);
 }
}
