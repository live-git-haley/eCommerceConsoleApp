
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cognixia.controller.Login;
import com.cognixia.controller.Purchase;
import com.cognixia.controller.ReadObjectsFromFile;
import com.cognixia.controller.WriteObjectsToFile;
import com.cognixia.exceptions.IncorrectInputException;
import com.cognixia.model.Customer;
import com.cognixia.model.Item;
import com.cognixia.model.ItemHistory;
import com.cognixia.view.Printing;

public class Main {
	

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException, IncorrectInputException {
	
		ReadObjectsFromFile in = new ReadObjectsFromFile();
		WriteObjectsToFile out = new WriteObjectsToFile();
		
		Printing print = new Printing();
		Purchase purchase = new Purchase();
		Login login = new Login();
		Customer currentC = new Customer();
		
		Set<Customer> customers = new HashSet<Customer>();
		Map<Long,List<ItemHistory>> allHistory = new HashMap<Long,List<ItemHistory>>();
		
		Map<Long,Item> allItems = in.readFilefromTxt("src/main/resources/items.txt");

	
		boolean running = true;
		boolean loggedin = false;
		Long check = -1L;
		while(running) {
		if(loggedin) {
			for(Customer c: customers) {
				if(c.getId() == check) {
					currentC = c;
					List <ItemHistory> myItems = allHistory.get(currentC.getId());

					System.out.println();
					System.out.println("--------Welcome Back, " + currentC.getName() + "--------");
					System.out.println();
					
					int choiceL = print.loginWelcomeMessage();
					
					switch(choiceL) {
					
					//purchase items
					case 1: 
						print.printItems(allItems);
						List<ItemHistory> purchased = purchase.purchaseItems(allItems);
						if(allHistory.containsKey(currentC.getId())) {
							List<ItemHistory> current = allHistory.get(currentC.getId());
							for(ItemHistory p: purchased) {
								allHistory.get(currentC.getId()).add(p);
							}
							
						}
						else {
							allHistory.put(currentC.getId(), purchased);
						}
						for(ItemHistory i: purchased) {
							System.out.println(i.getItem().getId());
							allItems.remove(i.getItem().getId());
							
						}
						
						
						
				
						break;
					//return items
					case 2:
						List<Long> picked =print.returnPrint(myItems);
						for(int i = 0; i <= myItems.size()-1; i++) {
							//Adding items back to inventory for All Items
							for(Long itemId: picked) {
								if(myItems.get(i).getId() == itemId ) {
									System.out.println(myItems.get(i).toString());
									allItems.put(itemId, myItems.get(i).getItem());

									allHistory.get(currentC.getId()).remove(myItems.get(i));
								};
							}
							
						
							
							//Removing items from itemList
							
						}
						
						
						
						
						
							
						break;
					//view items	
					case 3:
						System.out.println("My Items");
						for(ItemHistory i: myItems) {
							System.out.println(i);
						}
						
					
						break;
					//exit
					case 4:
						System.out.println("You logged out.");
						break;
						
					
					
				}
				
			}
		}
			
		
		}
		else {
			System.out.println();

			System.out.println("------------------Welcome to your Online Shop!------------------");

		
		int choice = print.welcomeMessage();
		
		
		switch(choice) {
		
		case 1: 
			if(loggedin) {
			print.printItems(allItems);
			}
			else {
				System.out.println("You must Login first");
			}
			break;
		case 2:
			check = print.login(customers);
			if(check != -1L) {
				loggedin = true;
				
			}
			else {
				System.out.println("Incorrect username or password");
			}
			break;
		case 3:
			Customer c1 = print.register();
			customers.add(c1);
			currentC = c1;
			break;
			
		case 4:
			running = false;
			break;
			
		
	
	}
		}
		}
	
}
}
