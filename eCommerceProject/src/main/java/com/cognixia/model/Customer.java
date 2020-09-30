package com.cognixia.model;

public class Customer {
	
	private static Long count;
	
	static {
		count = 1L;
	}
	
	private Long id;
	private String name;
	private String username;
	private String password;
	
	public Customer(String name, String username, String password) {
		super();
		this.id = count++;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public Customer() {
		this.id = count++;
		this.name = "N/A";
		this.username = "N/A";
		this.password = "N/A";
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

	
	
	

}
