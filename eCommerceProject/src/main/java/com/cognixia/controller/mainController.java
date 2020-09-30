package com.cognixia.controller;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.cognixia.model.Customer;
import com.cognixia.model.Item;

public class mainController {
	
	public static void printItems() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		ReadObjectsFromFile in = new ReadObjectsFromFile();
		WriteObjectsToFile out = new WriteObjectsToFile();
		
		
		Map<Long,Item> textItems = in.readFilefromTxt("src/main/resources/items.txt");
		
		
		System.out.println("Here are the items in the store");	
		System.out.println();
		System.out.println("Name ---------------- Price ----- Size -- ID");
		System.out.println();
		
		for(Item i: textItems.values()) {
			
			
			int diff = 20 - i.getName().length();
			
			
			int count = 1;

			String space = " ";
			
			while (count != diff) {
				System.out.print(space);
				count++;
			}
			System.out.println(i.getName() + "   " + i.getPrice() + "          " + i.getSize() + "     " + i.getId());
			
			
		}
	}
	
	
	public static Set<Integer> purchaseItems() {
		System.out.println("Please enter items you would like to purchase followed by 'Enter', press 0 when Done." );
		Set<Integer> items = new HashSet<Integer>();
		
		Scanner input = new Scanner(System.in);
		
		int item = input.nextInt();
		items.add(item);
	
		do {
			System.out.println("Please enter Item # : ");
			item = input.nextInt();
			if(item!= 0) {
			items.add(item);
			}
		}
		
		while (item!= 0);
		
		return(items);

	}
	
	
	public static int welcomeMessage() {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("------------------Welcome to your Online Shop!------------------");
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("1: View Items in Store");
		System.out.println("2: Login");
		System.out.println("3: Register New Account");
		System.out.println("4: Exit");

		int choice = input.nextInt();
		/*
		 * input.close();
		 */
		return(choice);
	}
	
	public static Customer register() {
		
		Customer newC = new Customer();
		Scanner input = new Scanner(System.in);
		System.out.println("------------------Register New Account------------------");
		System.out.println();
	
		
		System.out.print("Please enter your name: ");
		String name = input.next();
	
			
		System.out.print("Please enter a username: ");
		String username = input.next();
		System.out.print("Please enter a password: ");
		String password = input.next();
		
		newC.setName(name);
		newC.setUsername(username);
		newC.setPassword(password);
		
		System.out.println(newC.toString());
		
		
		
		input.close();
		return newC;

		
		
		
	}
	
	
	public static void makeInvoice(Set<Integer> items, Map<Long,Item> allItems) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		
		System.out.println("_________Invoice________");
		System.out.println();
		double total = 0.0;
		for(int i: items) {
			Long id = Long.parseLong(Integer.toString(i));
			System.out.println(allItems.get(id));
			total = total + allItems.get(id).getPrice();
		}
		
		System.out.println("Your total is: " +  total);
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
	
//		Customer c1 = new Customer("Haley", "hahowell", "haley1234");
//		Customer c2 = new Customer("Kobe", "kch", "kobe1234");
//		
//		Set<Customer> customers = new HashSet<Customer>();
//		
//		customers.add(c1);
//		customers.add(c2);
//	
//		ReadObjectsFromFile in = new ReadObjectsFromFile();
//		WriteObjectsToFile out = new WriteObjectsToFile();
//		
//		
//		Map<Long,Item> textItems = in.readFilefromTxt("src/main/resources/items.txt");
//	
//		
		
//		printItems();
//		Set<Integer> itemspicked = purchaseItems();
//		
//		System.out.println("These are the items you chose....");
//		
//		for(int i: itemspicked) {
//			System.out.println(i);
//		}
		

		
		
		
		//makeInvoice(itemspicked, textItems);

		
		
//		}
		int choice = welcomeMessage();
		
		switch(choice) {
		
		case 1: 
			printItems();
			break;
		case 2:
			System.out.println("You chose to login");
			break;
		case 3:
			register();
			break;
			
		case 4:
			System.out.println("You chose to exit");
			break;
			
		
	
	}
	
	
	}
}
//
//
//Date date=new java.util.Date();  
//System.out.println(date);
//
//
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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


