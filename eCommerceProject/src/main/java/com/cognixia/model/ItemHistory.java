package com.cognixia.model;

import java.util.Date;

public class ItemHistory {
	
	private Long id;
	private Date purchaseDate;
	private double price;
	private static Long count;
	private Item item;
	
	static {
		count = 1L;
	}
	
	
	public ItemHistory(Date purchaseDate, double price, Item item) {
		super();
		this.id =item.getId();
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.item = item;
	}
	
	public ItemHistory() {
		this.id = item.getId();
		this.purchaseDate = new Date();
		this.price = 0.0;
		this.item = new Item();
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Item #" + this.id + "[ purchaseDate=" + purchaseDate + " item=" + item.toString() + "]";
	}

	

}
