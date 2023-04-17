package com.employee.Exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("timeStamp", new Date());
		responseBody.put("Statuscode", status.value());
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> listOfErrors = new ArrayList<>();
		for (FieldError fieldError : fieldErrors) {
			String errorMessages = fieldError.getDefaultMessage();
			listOfErrors.add(errorMessages);

		}
		responseBody.put("Validation Is Failed", listOfErrors);

		return new ResponseEntity<>(responseBody, headers, status);
	}

}
