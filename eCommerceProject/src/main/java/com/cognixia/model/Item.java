package com.cognixia.model;

public class Item {
	
	enum Category {
		CLOTHES,
	    SHOES,
	    ACCESSORIES,
	    OTHER
	  }
	private Long id;
	private String name;
	private double price; 
	private Category category;
	
	public Item(Long id, String name, double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public Item() {
		this.id = -1L;
		this.name = "N/A";
		this.price = 0.0;
		this.category = Category.OTHER;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
