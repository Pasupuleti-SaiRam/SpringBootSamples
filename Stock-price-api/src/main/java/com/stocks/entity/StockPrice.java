package com.stocks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Stock_Details")
public class StockPrice {
	@Id
	@Column(name="Stock_Id")
	private Integer id;
	
	@Column(name="Company_Name")
	private String name;
	
	@Column(name="Company_Price")
	private Double price;
	public StockPrice() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
