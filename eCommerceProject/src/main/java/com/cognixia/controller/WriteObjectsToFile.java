package com.cognixia.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.cognixia.model.Item;

import java.io.*;


public class WriteObjectsToFile {
	enum Size{
		S,
		M,
		L,
		XL
	}
    
//		public Map<Long,Item> readFilefromTxt(String filepath) throws FileNotFoundException, IOException, ClassNotFoundException {
//			
//			Map<Long,Item> items = new HashMap<Long,Item>();
//			Item item = new Item();
//			
//			BufferedReader br = new BufferedReader(new FileReader(filepath));
//			
//			try {
//			    String line = br.readLine();
//			    
//				while (line != null) {
//			    	System.out.println();
//			    	String [] split = line.split(",");
//			    	System.out.println();
//			    	List<String> split2 = Arrays.asList(split);
//			    	
//			    	for(int i = 0; i <= split2.size(); i++) {
//			    	
//			    		switch(i) {
//			    			case 0: 
//			    				item.setId(Long.parseLong(split2.get(i)));
//			    				break;
//			    			case 1: 
//			    				item.setName(split2.get(i));
//			    				break;
//			    			case 2:
//			    				double price = Double.parseDouble(split2.get(i));
//			    				item.setPrice(price);
//			    				break;
//			    			case 3:
//			    				item.setCategory(split2.get(i));
//			    				break;
//			    			case 4:
//			    				item.setSize(split2.get(i));
//			    		
//			    				break;
//			    	
//			    	}
//			    		
//			    	
//			    	}
//			    	System.out.println(item.toString());
//			    	items.put(item.getId(), item);
//			    	line  = br.readLine();
//				}
//			}
//			finally {
//				System.out.println("finally block..");
//				
//			}
//			return(items);
//		}
//		
		
public void writeFiletoBytes(String filename, Map<Long,Item> items ) throws FileNotFoundException, IOException, ClassNotFoundException {
			
	FileOutputStream fileOutputStream = new FileOutputStream(filename);
	ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
	
	for(Item i: items.values()) {
		out.writeObject(i);
	}

	fileOutputStream.close();
	out.close();
	
	System.out.println("Wrote objects to file..");
	
}



}


		
