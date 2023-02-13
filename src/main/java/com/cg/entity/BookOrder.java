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
@Table(name="bookorders")
public class BookOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="cust_id")
	//private Customer customer;
	
	@Column(name="orderDate")
	private LocalDate orderDate;
	
	@Column(name="orderTotal")
	private double orderTotal;
	
	@Column(name="status")
	private String status;
	
	//@OneToOne
	//private Address shippingAddress;
	
	@Column(name="paymentMethod")
	private String paymentMethod;
	
	@Column(name="recipientName")
	private String recipientName;
	
	//@OneToOne(cascade=CascadeType.ALL,mappedBy="bookorder")
	//private OrderDetails orderdetails;
	
	@Column(name="recipientPhone")
	private String recipientPhone;
	
	public BookOrder()
	{
		
	}

	public BookOrder(Customer customer, LocalDate orderDate, double orderTotal, String status, Address shippingAddress,
			String paymentMethod, String recipientName, OrderDetails orderdetails, String recipientPhone) {
		super();
		//this.customer = customer;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.status = status;
		//this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.recipientName = recipientName;
		//this.orderdetails = orderdetails;
		this.recipientPhone = recipientPhone;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	//public Customer getCustomer() {
	//	return customer;
	//}

	//public void setCustomer(Customer customer) {
		//this.customer = customer;
	//}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//public Address getShippingAddress() {
		//return shippingAddress;
	//}

	//public void setShippingAddress(Address shippingAddress) {
		//this.shippingAddress = shippingAddress;
	//}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	//public OrderDetails getOrderdetails() {
		//return orderdetails;
	//}

	//public void setOrderdetails(OrderDetails orderdetails) {
		//this.orderdetails = orderdetails;
	//}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Override
	public String toString() {
		return "BookOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + ", status="
				+ status + ", paymentMethod=" + paymentMethod + ", recipientName=" + recipientName + ", recipientPhone="
				+ recipientPhone + "]";
	}

	
}