package com.employee.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "EmployeeDetails")

public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	@Column(name="EmployeeId")
	private Integer empId;
	
	@NotEmpty(message = "Name must not be empty")
	@Pattern(regexp = "^[a-zA-Z]+$",message = "Please Enter Characters Only")
	@Column(name="EmployeeName")
	private String empName;
	
	@Email(message = "Invalid email id")
	@Column(name="EmployeeEmail")
	private String email;
	
	@Size(min = 10,max=10,message = "Invalid Number")
	@Pattern(regexp = "^[0-9]+$",message = "Enter Numbers Only")
	@Column(name="EmployeePhNumber")
	private String phNumber;
	
	
	@CreationTimestamp
	@Column(updatable = false,name = "createdOn")
	private LocalDate createdOn;
	
	@Column(name="createdBy")
	private String createdBy;


	public Employee() {
		
	}


	public Employee(Integer empId,
			@NotEmpty(message = "Name must not be empty") @Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Characters Only") String empName,
			@Email(message = "Invalid email id") String email,
			@Size(min = 10, max = 10, message = "Invalid Number") @Pattern(regexp = "^[0-9]+$", message = "Enter Numbers Only") String phNumber,
			LocalDate createdOn, String createdBy) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.phNumber = phNumber;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}


	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhNumber() {
		return phNumber;
	}


	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}


	public LocalDate getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", phNumber=" + phNumber
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + "]";
	}
	


	
	
	
	

	

}
