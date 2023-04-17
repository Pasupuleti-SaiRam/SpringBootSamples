package com.employee.Dto;

import java.util.List;

import com.employee.Entity.Employee;

public class PageDto<T> {
	
	private List<Employee> pageData;
	private long totalElements;
	private int numberOfElements;
	private int totalPageNumber;
	
	public PageDto() {
		// TODO Auto-generated constructor stub
	}

	public List<Employee> getPageData() {
		return pageData;
	}

	public void setPageData(List<Employee> pageData) {
		this.pageData = pageData;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public int getTotalPageNumber() {
		return totalPageNumber;
	}

	public void setTotalPageNumber(int totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}

	
	

}
