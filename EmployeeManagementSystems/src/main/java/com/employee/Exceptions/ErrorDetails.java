package com.employee.Exceptions;

import java.util.Date;

import org.springframework.stereotype.Component;

public class ErrorDetails {
	
	private Date timeStamp;
	private String errorMessage;
	private String details;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorDetails(Date timeStamp, String errorMessage, String details) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

}
