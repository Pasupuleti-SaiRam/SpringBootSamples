package com.scheduler.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	private int stuid;
	private String name;
	private String email;
	private boolean active = true;

	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setactive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", email=" + email + ", active=" + active
				+  "]";
	}
	public Student(int stuid, String name, String email, boolean active) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.email = email;
		this.active = active;
		
	}
	public Student() {
		super();
		
	}
	
	
	
}
