package com.sales.microservices.salesorderservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "order_line_item")
public class OrderLineItem {

	@Id
	@Column(name = "item_id")
	@GeneratedValue
	private int itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "quantity")
	private int quantity;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public OrderLineItem() {

	}

	public OrderLineItem(String itemName, int quantity) {
		this.itemName = itemName;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
