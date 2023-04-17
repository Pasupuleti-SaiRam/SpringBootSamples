package com.stocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entity.StockPrice;
import com.stocks.service.StockPriceService;

@RestController
public class StrockPriceController {
	@Autowired
	private StockPriceService service;
	@GetMapping("/price/{companyName}")
	public ResponseEntity<StockPrice> getStockPrice(@PathVariable String companyName){
		StockPrice stockPrice = service.getStockPrice(companyName);
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.OK);
		
	}

}
