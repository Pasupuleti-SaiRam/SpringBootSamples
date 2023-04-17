package com.user.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.user.exceptons.UserNotFoundException;

import com.user.responsebinding.User;
@Component
public class UserServices {
String url="https://jsonplaceholder.typicode.com/users";
	
	public ResponseEntity<List<User>>  sendHttpRequest(String url, HttpMethod method, HttpHeaders headers, Object body, ParameterizedTypeReference<List<User>> parameterizedTypeReference) {
	    RestTemplate restTemplate = new RestTemplate();
	    HttpEntity<Object> requestEntity = new HttpEntity<>(body, headers);
	      ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url, method, requestEntity, parameterizedTypeReference);
	    return responseEntity;
	}


	
	  public List<User> getAllUsers() { 
		  ResponseEntity<List<User>> responseEntity =sendHttpRequest(url, HttpMethod.GET, null, null, new ParameterizedTypeReference<List<User>>() {}); 
		  List<User> userResponse =responseEntity.getBody(); 
		  return userResponse; 
		  }
	 
	
	public User saveUser(User user) {
		
	    HttpHeaders headers = new HttpHeaders();
	    // Add any required headers here

	    //ResponseEntity<User> responseEntity = sendHttpRequest(url, HttpMethod.POST, headers, user, new ParameterizedTypeReference<User>() {});
	   // User userResponse = responseEntity.getBody();
	    return null;
		
	}
	public User getUserById(Integer userId) throws UserNotFoundException  {
		String url="https://jsonplaceholder.typicode.com/users/{userId}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class,userId);
		System.out.println("status code "+ forEntity.getStatusCode());
		 if (forEntity.getStatusCode() != HttpStatus.OK) {
			 throw new UserNotFoundException("user is not present with this id"+": "+userId);
		    }else {
		   	 User responseBody = forEntity.getBody();
				return responseBody;
				
			}
		
		
	}

}
