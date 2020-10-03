package com.cognixia.controller;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	
	public List<ItemHistory> purchaseItems(Map<Long,Item> items) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ItemHistory> history = new ArrayList <ItemHistory>();
		System.out.println("Please enter items you would like to purchase followed by 'Enter', press 0 when Done." );
		
		
		Scanner input = new Scanner(System.in);
		
		int item = input.nextInt();
		
		Long id = Long.parseLong(Integer.toString(item));
		Item i = items.get(id);
		System.out.print("You chose ---> ");
		System.out.println(i.toString());
		ItemHistory itemH1 = new ItemHistory(new Date(),items.get(id).getPrice(), i);

		history.add(itemH1);
	
		do {
			System.out.println();
			System.out.println("Please enter Item # : ");
			item = input.nextInt();
			Long id2 = Long.parseLong(Integer.toString(item));
			Item i2 = items.get(id2);

			if(item!= 0) {
				System.out.print("You chose ---> ");
				System.out.println(i2.toString());
				ItemHistory itemH = new ItemHistory(new Date(),items.get(id2).getPrice(), items.get(id2) );
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


