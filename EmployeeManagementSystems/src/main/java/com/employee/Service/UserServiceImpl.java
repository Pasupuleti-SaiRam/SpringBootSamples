package com.employee.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.Entity.User;
import com.employee.Repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService{// here we impliments UserDetailsService its comes to security frmwk
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	

	@Override
	public User saveUser(User user) {
		//Encode Password
		String encodedPassword = pwdEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		return userRepo.save(user);

	}


	@Override
	public Optional<User> findByUsername(String username) {
		Optional<User> user = userRepo.findByUserName(username);
		return user;
	}

// this is security method
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optUser = findByUsername(username);
		if(optUser.isEmpty())
			throw new UsernameNotFoundException("User not exist..");
		//read user from DB
		User user = optUser.get();
		
		return new org.springframework.security.core.userdetails.User(
				username,
				user.getPassword(),
				user.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role))
				.collect(Collectors.toList())
				);
	}
	

}
