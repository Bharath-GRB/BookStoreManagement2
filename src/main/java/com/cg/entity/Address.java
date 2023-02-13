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
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "pincode")
	private String pincode;

	@OneToOne(mappedBy="address")
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Customer customer;
	public Address() {
	}

	public Address(String city, String country, String pincode) {
		super();
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", country=" + country + ", pincode=" + pincode
				+ "]";
	}
}
