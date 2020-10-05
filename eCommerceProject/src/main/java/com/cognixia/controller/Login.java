package com.cognixia.controller;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cognixia.model.Customer;


public class Login {
	
	
	
	public static boolean passwordMatcher(String password) {

			//Must be atleast 4 characters, one special character and one number 
		   Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$", Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(password);
		    boolean matchFound = matcher.find();
		    if(matchFound) {
		      return true;
		    } else {
		      return false;
	    }
		

		
	}
	
	public Long checkLogin(String username, String password, Set<Customer> customers) {
		
		for(Customer c: customers) {
			if(c.getUsername().equals(username) && c.getPassword().equals(password)) {
				return(c.getId());
			}
		}
		
		return -1L;
		
	}
	
	public static void main(String[] args) {
		System.out.println(passwordMatcher("haley"));
		System.out.println(passwordMatcher("haley2"));
		System.out.println(passwordMatcher("haley2$"));
		System.out.println(passwordMatcher("ha"));
		System.out.println(passwordMatcher("hale$3"));


	}

}
