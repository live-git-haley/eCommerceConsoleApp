package com.cognixia.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.cognixia.controller.Login;
import com.cognixia.model.Customer;
import com.cognixia.model.Item;
import com.cognixia.model.ItemHistory;

import com.cognixia.exceptions.*;

public class Printing {
	
	public int welcomeMessage() {
		
		
		Scanner input = new Scanner(System.in);
		int choice =0;
		do {
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("1: View Items in Store");
		System.out.println("2: Login");
		System.out.println("3: Register New Account");
		System.out.println("4: Exit");
		

		try {
			choice = input.nextInt();
			
		}
		catch(InputMismatchException e){
			//throw new IncorrectInputException("Please enter a number...");
			System.out.println("Please enter a valid number...");
		
		}
		input.nextLine();
		}
		while(choice!= 4 && choice!=2 && choice!=3 && choice!=1);
		/*
		 * input.close();
		 */
		return(choice);
	}
	
	public int loginWelcomeMessage() {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("1: Purchase Items");
		System.out.println("2: Return an Item");
		System.out.println("3: View My Items");
		System.out.println("4: Exit");

		int choice = input.nextInt();
		/*
		 * input.close();
		 */
		return(choice);
	}
	
	

	public void printItems(Map<Long,Item> textItems) {
		
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
	
	public Customer register() {
		
		Customer newC = new Customer();
		Login login = new Login();
		Scanner input = new Scanner(System.in);
		System.out.println("------------------Register New Account------------------");
		System.out.println();
	
		
		System.out.print("Please enter your name: ");
		String name = input.next();
	
			
		System.out.print("Please enter a username: ");
		String username = input.next();
		System.out.print("Please enter a password: ");
		System.out.println();
		System.out.println("*Must be atleast 4 characters long, include one special character and one number");
		String password = input.next();
		
		boolean check = login.passwordMatcher(password);
		while(check != true) {
			System.out.println("Please enter a valid password...");
			System.out.println();
			System.out.print("Please enter a password: ");
			System.out.println();
			System.out.println("*Must be atleast 4 characters long, include one special character and one number");
			password = input.next();
			check = login.passwordMatcher(password);
		}
		newC.setName(name);
		newC.setUsername(username);
		newC.setPassword(password);
		
		System.out.println();
		System.out.println("Congratulations, you have now registered a new account!   ");
		System.out.println();
		
		
		return newC;

		
		
		
	}
	
	public void makeInvoice(Set<Integer> items, Map<Long,Item> allItems) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		
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
	
	
	public Long login(Set<Customer> customers) {
		Scanner input = new Scanner(System.in);
		Login login = new Login();
		System.out.println("-------LOGIN--------");
		System.out.print("Username: ");
		String username = input.next();
		System.out.print("Password: ");
		String password = input.next();
		
		Long check = login.checkLogin(username, password, customers);
		
		return check;
		
	}
	
	public List<Long> returnPrint(List<ItemHistory> purchased) throws IncorrectInputException{
		List<Long> itemsNums = new ArrayList<Long>();
		Date today = new Date();
		System.out.println();
		int number = 0;
		int count =1;
		for(ItemHistory i: purchased) {
			if(count == 2) {
				Date d1 = new Date(2020, 01, 01);
				i.setPurchaseDate(d1);
				
			}
			count++;
			
			System.out.println(i.toString());
		}
		
		Scanner in = new Scanner(System.in);
		int itemNum = 100;
		Long valid = -100L;
		for(ItemHistory k: purchased) {
			int itemDate = k.getPurchaseDate().getMonth();
			int todayDate = today.getMonth();
			if( todayDate-itemDate > 3) {
				
				 valid = k.getId();
			}
		}
		
		do {
		 
			System.out.println("Please select Items to return: ");
			System.out.println("Press 0 to Enter");
			System.out.println();
			try {
			itemNum = in.nextInt();
				
			
			}
			catch (InputMismatchException e) {
				
				System.out.println("Please enter a valid number....");
				in.nextLine();
			}
		
			if(itemNum == valid) {
				System.out.println("Unable to make return: You must return this item within 3 months of purchase date...");
				continue;
			}
			
			else if(itemNum!= 0 && valid != -100L) {
			itemsNums.add(Long.parseLong(Integer.toString(itemNum)));
			}
		}
		while(itemNum!= 0);
		

		
		return(itemsNums);
	
	}
	
	public static void main(String[] args) {
		
		Date today = new Date();
		System.out.println(today);
		Date d1 = new Date(2020, 01, 01);
		System.out.println(d1);
		System.out.println(today.getMonth());
		System.out.println(d1.getMonth());
		System.out.println(today.getYear());
		System.out.println(d1.getYear());
		
	}
		
		
		
		
		
		
	
	
	
	
	

}
