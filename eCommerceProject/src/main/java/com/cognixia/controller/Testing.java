package com.cognixia.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cognixia.model.Item;

public class Testing {
	
	
	public static void reverse(String s) {
		String[] split = s.split(" ");
		String newString = "";
		for(int i = split.length-1; i >= 0; i--) {
			newString = newString + " " + split[i];
		}
		
		System.out.println(newString);
		
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		reverse("Hello I am Haley");
		
	}

}
