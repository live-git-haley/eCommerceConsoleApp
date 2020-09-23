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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cognixia.model.Item;

import java.io.*;


public class ObjectsIn {
	

    
		public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
			
			
//			FileInputStream fileInputStream = new FileInputStream("src/main/resources/items.txt");
//			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Map<Long,Item> items = new TreeMap<Long,Item>();
			Map<Long,Item> items2 = new HashMap<Long,Item>();
			
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/items.txt"));
			String everything;
			
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			    	
			    	Item item = new Item();
			    	String [] one = line.split(",");
			    	int size = one.length;
			    	List two = Arrays.asList(one);
			    	int count = 1;
			    	for(String s:one) {
			    		if(count!=5) {
			    			switch(count) {
			    			
			    			case 1:
			    				item.setId(Long.parseLong(s));
			    				break;
			    			case 2:
			    				item.setName(s);
			    				break;
			    			case 3:
			    			
			    				item.setPrice(Double.parseDouble(s));
			    				break;
			    			case 4:
			    				item.setCategory(s);
			    				break;	
			    			case 5:
			    				item.setSize();
			    				break;
			    			}
			    			System.out.println();
			    			count++;
			    		}
			    		else {
			    		System.out.println(item.toString());
			    		items.put(item.getId(), item);
			    		items2.put(item.getId(), item);

			    		
			    		System.out.println();
			    		count = 1;
			    	}
			    	}

			   
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    everything = sb.toString();
			} finally {
			    br.close();
			}
			
//				
//			while(fileInputStream.available() != 0) {
//				Item item = null;
//				//<Person> test_listy = null;
//				//test_listy =  objectInputStream.readObject();
//				item = (Item) objectInputStream.readObject();
//				items.put(item.getId(), item);
//
//			
			
			
			
			System.out.println("FINAL LISTTTTT TREE MAP");
			
			
			for(Item i: items.values()) {
				System.out.println(i.toString());
			}
			System.out.println();

			System.out.println("FINAL LISTTTTT HASH MAP");
			
			
			for(Item i: items2.values()) {
				System.out.println(i.toString());
			}
		
			

	}
//			fileInputStream.close();
//			objectInputStream.close();
			
		
	}



