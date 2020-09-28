package com.cognixia.model;

import java.io.Serializable;

public class Item implements Serializable{
	
	enum Size {
		S,
		M,
		L,
		XL
	  }
	private Long id;
	private String name;
	private double price;
	private String category;
	private Size size;
	
	public Item(Long id, String name, double price, String category, Size size) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.size = size;
	}
	
	public Item() {
		
		this.id = -1L;
		this.name = "Na";
		this.price = 0.0;
		this.category = "Na";
		this.size = Size.L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(String s) {
		switch(s) {
		case "S": 
			this.size = Size.S;
			break;
		case "M":
			this.size = Size.M;
			break;
		case "L":
			this.size = Size.L;
			break;
		case "XL":
			this.size = Size.XL; 
			break;
		
		}
	}
	

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", size=" + size
				+ "]";
	}
	
	
	
}
