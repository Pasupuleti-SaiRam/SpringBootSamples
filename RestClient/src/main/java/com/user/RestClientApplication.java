package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
		
		/*// this public api url String
		 * // https://jsonplaceholder.typicode.com/users 
		 * 
		 * url="https://jsonplaceholder.typicode.com/users"; // here creating
		 * resttemplate for sending request RestTemplate rt=new RestTemplate(); //
		 * sending get request ResponseEntity<String> response = rt.getForEntity(url,
		 * String.class); String bodyResult = response.getBody();
		 * System.out.println(bodyResult);
		 */
	}

}
