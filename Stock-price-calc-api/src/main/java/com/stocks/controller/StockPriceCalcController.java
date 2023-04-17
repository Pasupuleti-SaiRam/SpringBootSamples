package com.stocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stocks.binding.StockPrice;
import com.stocks.feignclient.StockPriceClient;

@RestController
public class StockPriceCalcController {
	@Autowired
	private StockPriceClient priceClient;
	
	@GetMapping("calc/{cname}/{quantity}")
	public ResponseEntity<String> calculate(@PathVariable String cname,@PathVariable Integer quantity){
		
		//String url="http://localhost:1111/price/{cname}";
		//RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<StockPrice> resEntity = restTemplate.getForEntity(url, StockPrice.class,cname);
		//StockPrice body = resEntity.getBody();
		//Double companyPrice = body.getPrice();
		
		
		StockPrice stockPrice = priceClient.invokeStockPrice(cname);
		Double companyPrice = stockPrice.getPrice();
		Double totalCost=companyPrice*quantity;
		String msg="Total Cost of"+" "+cname+" "+"is"+" "+totalCost;
		return new ResponseEntity(msg,HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
