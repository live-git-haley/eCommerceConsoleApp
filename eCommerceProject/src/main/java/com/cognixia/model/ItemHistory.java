package com.cognixia.model;

import java.util.Date;

public class ItemHistory {
	
	private Long id;
	private Date purchaseDate;
	private double price;
	private static Long count;
	
	static {
		count = 1L;
	}
	
	
	public ItemHistory(Date purchaseDate, double price) {
		super();
		this.id = count++;
		this.purchaseDate = purchaseDate;
		this.price = price;
	}
	
	public ItemHistory() {
		this.id = count++;
		this.purchaseDate = new Date();
		this.price = 0.0;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemHistory [id=" + id + ", purchaseDate=" + purchaseDate + ", price=" + price + "]";
	}
	
	

}
