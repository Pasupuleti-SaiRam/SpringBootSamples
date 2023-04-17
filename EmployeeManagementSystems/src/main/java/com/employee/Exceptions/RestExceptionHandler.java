package com.employee.Exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request){
		
		Map<String, Object> errors=new HashMap<>();
		errors.put("timeStamp", new Date());
		errors.put("status", HttpStatus.BAD_REQUEST);
		errors.put("error", HttpStatus.NOT_FOUND);
		errors.put("message", ex.getMessage());	
		return new ResponseEntity<Object>(errors,HttpStatus.NOT_FOUND);
		
		
		
	}
	

}

	 
	
