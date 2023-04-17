package com.stocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockPriceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceApiApplication.class, args);
	}

}
