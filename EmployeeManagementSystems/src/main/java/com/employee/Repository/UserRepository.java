package com.employee.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	Optional<User> findByUserName(String username);
	 
	

}
