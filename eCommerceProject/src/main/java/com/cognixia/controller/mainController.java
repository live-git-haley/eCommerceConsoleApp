package com.cognixia.controller;

import java.util.Scanner;

public class mainController {
	
	
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
		input.close();
		
		return(choice);
	}
	
	
	
	public static void main(String[] args) {
		
		
		int choice = welcomeMessage();
		
		switch(choice) {
		
		case 1: 
			System.out.println("You chose to view the store");
			break;
		case 2:
			System.out.println("You chose to login");
			break;
		case 3:
			System.out.println("You chose to register a new Account");
			break;
			
		case 4:
			System.out.println("You chose to exit");
			break;
			
		
		
		
		}
	
	
	}

}
