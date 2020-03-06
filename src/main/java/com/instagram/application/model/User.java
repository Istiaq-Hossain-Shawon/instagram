package com.instagram.application.model;

import javax.persistence.*;

import com.instagram.application.enums.Role;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "Name")
    private String Name;   
	@Column(name = "password", length = 512)
    private String password;
    
	@Column(name = "logo", nullable = true)
	private String logo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private Role role;
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
    @Column(name = "Age")
    private int Age;
    @Column(name = "DOB")
    private Date DOB;
    public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
    public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public long getId() {
        return userId;
    }

    public void setId(long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public User() {
		super();
	}	
}
