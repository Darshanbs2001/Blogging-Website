package com.blog.api;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.api.Exceptions.NoUsersFound;
import com.blog.api.Exceptions.ResourceNotFound;
import com.blog.api.utilities.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler({ResourceNotFound.class})
public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFound rx){
	return new ResponseEntity<ApiResponse>(new ApiResponse(rx.getMessage(),false),HttpStatus.NOT_FOUND);
}
@ExceptionHandler({NoUsersFound.class})
public ResponseEntity<ApiResponse> usersNotFound(NoUsersFound n){
	return new ResponseEntity<ApiResponse>(new ApiResponse(n.getMessage(),false),HttpStatus.NOT_FOUND);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	
	Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error) ->{
		
		String fieldName = ((FieldError) error).getField();
		String message = error.getDefaultMessage();
		errors.put(fieldName, message);
	});
	return new ResponseEntity<Map<String,String>>(errors, HttpStatus.NOT_ACCEPTABLE);
}
@ExceptionHandler(SQLException.class)
public ResponseEntity<ApiResponse> handleSqlExceptions(SQLException e){
    return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage(),false),HttpStatus.NOT_ACCEPTABLE);
}
}
