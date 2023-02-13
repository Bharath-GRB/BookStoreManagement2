package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers_cust")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "fullName")
	private String fullName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne
	public User user;

	@Column(name = "registerOn")
	private LocalDate registerOn;

	public Customer() {
	}

	public Customer(String mobileNumber, String fullName, Address address, User user, LocalDate registerOn) {
		super();
		this.mobileNumber = mobileNumber;
		this.fullName = fullName;
		this.address = address;
		this.user = user;
		this.registerOn = registerOn;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getRegisterOn() {
		return registerOn;
	}

	public void setRegisterOn(LocalDate registerOn) {
		this.registerOn = registerOn;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", mobileNumber=" + mobileNumber + ", fullName=" + fullName
				+ ", address=" + address + ", user=" + user + ", registerOn=" + registerOn + "]";
	}

}