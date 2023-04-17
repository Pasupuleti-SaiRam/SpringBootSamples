package com.user.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.exceptons.UserNotFoundException;

import com.user.responsebinding.User;
import com.user.service.UserService;

@RestController

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public String hello()
	{
		return "Hello";
	}
	
	@GetMapping(value="/user")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
}
	  
    @GetMapping("/user/{name}")
    public ResponseEntity<?> getUsers(@PathVariable(value="name") String name) {
        List<User> users = userService.getAllUsers();
        
        if (name != null) {
            users = users.stream()
                    .filter(user -> user.getName().equals(name))
                    .collect(Collectors.toList());
        }
        
        return ResponseEntity.ok(users);
    }
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
    	User saveUser = userService.saveUser(user);
    	return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
    	
    }
    @GetMapping("/user/info/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id) {
    	System.out.println("this for controler"+id);
		
			
				User user = userService.getUserById(id);
			
		
		return new ResponseEntity<>(user,HttpStatus.OK);
    }
    	
   
    
}
