package com.sb.store.modal;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 8145194157600454194L;

	private String itemName;
	
	private int qty;
	
	private double price;
	
	private int port;

	public Item(String itemName, int qty, double price) {
		super();
		this.itemName = itemName;
		this.qty = qty;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
