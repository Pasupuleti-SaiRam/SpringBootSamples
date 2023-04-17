package com.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth.entities.Product;
import com.oauth.repository.ProductRepository;

@Service
public class ProductServiceImpl  implements ProductService{
	@Autowired
	private ProductRepository repo;
	@Override
	public List<Product> getProduct() {
		List<Product> products = repo.findAll();
		return products;
	}

}
