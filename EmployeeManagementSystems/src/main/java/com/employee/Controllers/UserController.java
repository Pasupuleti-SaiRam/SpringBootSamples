package com.employee.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.User;
import com.employee.Entity.UserRequest;
import com.employee.Entity.UserResponse;
import com.employee.Service.UserServiceImpl;
import com.employee.Util.JwtUtil;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<UserResponse>loginUser(@RequestBody UserRequest req)
	{
		// To validate username & Password with DB
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));
		String generateToken = jwtUtil.generateToken(req.getUsername());
		return ResponseEntity.ok(new UserResponse(generateToken,"Token Generated success"));
	}
	@GetMapping("/hello")
	public String msg() {
		return "Hello..";
	}

}
