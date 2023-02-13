package com.cg.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Customer customer;
	
	public User() {
		
	}

	public User(String email,String password,
			String role) {
		super();
		
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}
	
	


}
