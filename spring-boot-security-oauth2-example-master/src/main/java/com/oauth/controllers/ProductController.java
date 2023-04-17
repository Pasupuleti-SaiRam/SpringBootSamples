package com.oauth.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.entities.Product;
import com.oauth.service.ProductServiceImpl;

@RestController
@RequestMapping("/oauth")
public class ProductController {
	@Autowired
	private ProductServiceImpl productService;
	@GetMapping(value="/products",produces = "application/json")
	public ResponseEntity<List<Product>> findProducts(){
		List<Product> products = productService.getProduct();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	@GetMapping("/")
	public String message(Principal principal) {
		System.out.println(principal.getName());
		return "Hi "+" "+principal.getName();
	}

}
