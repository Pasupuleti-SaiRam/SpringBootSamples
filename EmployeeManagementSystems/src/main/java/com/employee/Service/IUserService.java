package com.employee.Service;

import java.util.Optional;

import com.employee.Entity.User;

public interface IUserService {
	
	User saveUser(User user);
	Optional<User> findByUsername(String username);

}
