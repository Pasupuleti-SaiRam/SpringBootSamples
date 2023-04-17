package com.stocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

	public StockPrice findByName(String companyName);
}
