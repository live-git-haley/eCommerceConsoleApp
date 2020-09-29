package com.cognixia.model;

import java.util.Date;

public class ItemHistory {
	
	private Long id;
	private Date purchaseDate;
	private double price;
	
	
	
	public ItemHistory(Long id, Date purchaseDate, double price) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.price = price;
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
	

}
