package com.cognixia.controller;

import java.util.Map;
import java.util.Set;

import com.cognixia.model.Item;

public class Return {
	
	
	
	
	
	public Map<Long,Item> returnItems(Set<Item> items, Map<Long,Item> allItems ) {
		
		for(Item i: items) {
			allItems.put(i.getId(), i);
		}
		
		return(allItems);
		
	}
	

}
