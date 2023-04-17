package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;


@SpringBootApplication
public class RestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestConsumerApplication.class, args);
		/*
		 * // https://jsonplaceholder.typicode.com/users // this public api url String
		 * url="https://jsonplaceholder.typicode.com/users"; // here creating
		 * resttemplate for sending request RestTemplate rt=new RestTemplate(); //
		 * sending get request ResponseEntity<String> response = rt.getForEntity(url,
		 * String.class); String bodyResult = response.getBody();
		 * System.out.println(bodyResult);
		 */
		
	}

}
