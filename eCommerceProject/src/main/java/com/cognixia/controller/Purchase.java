package com.cognixia.controller;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.cognixia.model.Customer;
import com.cognixia.model.Item;
import com.cognixia.model.ItemHistory;

public class Purchase {

	
	public Set<ItemHistory> purchaseItems(Map<Long,Item> items) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Set<ItemHistory> history = new HashSet <ItemHistory>();
		System.out.println("Please enter items you would like to purchase followed by 'Enter', press 0 when Done." );
		
		
		Scanner input = new Scanner(System.in);
		
		int item = input.nextInt();
		ItemHistory itemH1 = new ItemHistory();
		Long id = Long.parseLong(Integer.toString(item));
		Item i = items.get(id);
		System.out.println(i.toString());
		itemH1.setPrice(items.get(id).getPrice());
		itemH1.setPurchaseDate(new Date());
		history.add(itemH1);
	
		do {
			System.out.println("Please enter Item # : ");
			item = input.nextInt();
			Long id2 = Long.parseLong(Integer.toString(item));

			if(item!= 0) {
				ItemHistory itemH = new ItemHistory(new Date(),items.get(id2).getPrice());
				history.add(itemH);
				
			}
			
		}
		
		while (item!= 0);
		
	
		
		return(history);

	}
	
	
	

	
	
	
	
	
	}

//
//
//Date date=new java.util.Date();  
//System.out.println(date);
//
////SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//
//try{
//	
//	Thread.sleep(4000); 
//	
//	String date4 = sdf.format(new Date());
//	
//	System.out.println(date4);
//	
//
//}catch(Exception e){}


