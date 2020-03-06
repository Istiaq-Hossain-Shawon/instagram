package com.instagram.application.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;





public class UserDto {
	private long id;
	private String username;
	private String name;
	private String password;
	private String confirmPassword;
private com.instagram.application.enums.Role role;
	
 
	public com.instagram.application.enums.Role getRole() {
	return role;
}
public void setRole(com.instagram.application.enums.Role role) {
	this.role = role;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
	private int age;
	
	private Date dob;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDOB() {
		return dob;
	}
	public void setDOB(Date dOB) {
		dob = dOB;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
