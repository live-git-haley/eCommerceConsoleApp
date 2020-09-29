package com.cognixia.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.cognixia.model.Item;

import java.io.*;


public class ReadObjectsFromFile {
	enum Size{
		S,
		M,
		L,
		XL
	}
    
		public Map<Long,Item> readFilefromTxt(String filepath) throws FileNotFoundException, IOException, ClassNotFoundException {
			
			Map<Long,Item> itemsMap = new Hashtable<Long,Item>();
			
			
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			try {
			    String line = br.readLine();
				while (line != null) {
			    	String [] split = line.split(",");
			    	List<String> split2 = Arrays.asList(split);
			    	Item item = new Item();
			    	for(int i = 0; i <= split2.size(); i++) {
			    		
			    		switch(i) {
			    			case 0: 
			    				item.setId(Long.parseLong(split2.get(i)));
			    				break;
			    			case 1: 
			    				item.setName(split2.get(i));
			    				break;
			    			case 2:
			    				double price = Double.parseDouble(split2.get(i));
			    				item.setPrice(price);
			    				break;
			    			case 3:
			    				item.setCategory(split2.get(i));
			    				break;
			    			case 4:
			    				item.setSize(split2.get(i));
			    		
			    				break;
			    	
			    	}
			    	
			    		
			    	
			    	}
			    	
			    	itemsMap.put(item.getId(), item);
			    	line  = br.readLine();
			    	
				}
			}
			finally {
				
			}
			
			
			
			return(itemsMap);
		}
		
		
public Map<Long,Item> readFilefromBytes(String filepath) throws FileNotFoundException, IOException, ClassNotFoundException {
			
	FileInputStream fileInputStream = new FileInputStream(filepath);
	ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	Map<Long,Item> items = new HashMap<Long, Item>();
		
	while(fileInputStream.available() != 0) {
		Item item = null;
		//<Person> test_listy = null;
		//test_listy =  objectInputStream.readObject();
		item = (Item) objectInputStream.readObject();
		items.put(item.getId(), item);

	}
	
	fileInputStream.close();
	objectInputStream.close();
	
	
	System.out.println();
	for(Item i: items.values()) {
		System.out.println(i.toString());
	}
	
	return(items);
	
}



}


		
