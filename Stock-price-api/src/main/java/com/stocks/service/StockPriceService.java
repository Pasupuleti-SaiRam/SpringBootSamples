package com.stocks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.entity.StockPrice;
import com.stocks.repository.StockPriceRepository;

@Service
public class StockPriceService {
	
	@Autowired
	private StockPriceRepository repo;
	public StockPrice getStockPrice(String companyName) {
		StockPrice stockPrice = repo.findByName(companyName);
		return stockPrice;
		
	}

}
