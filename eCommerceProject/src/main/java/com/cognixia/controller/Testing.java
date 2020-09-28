package com.cognixia.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cognixia.model.Item;

public class Testing {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		ReadObjectsFromFile in = new ReadObjectsFromFile();
		WriteObjectsToFile out = new WriteObjectsToFile();
		
		
		Map<Long,Item> textItems = in.readFilefromTxt("src/main/resources/items.txt");
		System.out.println("Items retrieved from TEXT file: ");
		System.out.println(textItems.size());
		for(Item i: textItems.values()) {
			System.out.println(i.toString());
		}
		
		out.writeFiletoBytes("testy.txt", textItems);
		
		Map<Long,Item> byteItems = in.readFilefromBytes("/Users/haleyhowell/Desktop/eCommerceConsoleApp/eCommerceProject/testy.txt");
		
		
		
		
	}

}
