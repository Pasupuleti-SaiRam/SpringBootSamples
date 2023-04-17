package com.user.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.exceptons.UserNotFoundException;

import com.user.responsebinding.User;
@Service
public class UserService {
	
	String apiUrl="https://jsonplaceholder.typicode.com/users/";

   private  RestTemplate restTemplate;

public UserService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
}


public List<User> getAllUsers() {
    String url = apiUrl;
    ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
    return responseEntity.getBody();
}

public User saveUser(User user) {
	  String url = apiUrl;
    HttpEntity<User> requestEntity = new HttpEntity<>(user);
    ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, User.class);
    return responseEntity.getBody();
}

public User getUserById(Integer userId){
    String url = apiUrl + userId;
    System.out.println(userId+""+url);
    ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, User.class);
    User user = responseEntity.getBody(); 
    return user;
}
}
