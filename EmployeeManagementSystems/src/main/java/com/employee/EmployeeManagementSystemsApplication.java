package com.employee;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

public class EmployeeManagementSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemsApplication.class, args);
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//String password="sai@123"; $2a$10$Mo54KUjEPiV4iKiylIGoV.2SMugXbI./PQV8WMpvWiP2U8RUBv226
		//String password="ram@123"; $2a$10$onNahX5uPXmWD7KHMRCjjeGOuBVTh4EAhfiFkDfb8PlueeiMfwuQm

		//String encode = encoder.encode(password);
		//System.out.println(encode);
	}

}
