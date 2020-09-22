package com.cognixia.model;

public class Customer {
	
	private double id;
	private String fname;
	private String username;
	private String password;
	private String address;
	
	public Customer(double id, String fname, String username, String password, String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.username = username;
		this.password = password;
		this.address = address;
	}
	
	public Customer() {
		this.id = -1L;
		this.fname = "N/A";
		this.username = "N/A";
		this.password = "N/A";
		this.address = "N/A";
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
