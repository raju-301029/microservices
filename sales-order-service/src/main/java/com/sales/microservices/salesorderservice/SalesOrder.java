package com.sales.microservices.salesorderservice;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "sales_order")
public class SalesOrder {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "date")
	private Date date;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Set<OrderLineItem> orderLineItems;

	public Set<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	public int getId() {
		return id;
	}

	public void setOrderId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SalesOrder(Date date, String emailId, String description, double price) {
		super();
		this.date = date;
		this.emailId = emailId;
		this.description = description;
		this.price = price;
	}

	public SalesOrder() {

	}

}
