package com.user.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.responsebinding.User;

@Service
public class UserService {
	
	public List<User> getAllUsers(){
	String url="https://jsonplaceholder.typicode.com/users";
	
	RestTemplate rt=new RestTemplate();
	ResponseEntity<List<User>> responseEntity = rt.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {
	});
	List<User> userResponse = responseEntity.getBody();
	return userResponse;
	
	
	
	
	
	}
	
	
	

}
