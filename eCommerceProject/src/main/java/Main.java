
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cognixia.controller.Login;
import com.cognixia.controller.Purchase;
import com.cognixia.controller.ReadObjectsFromFile;
import com.cognixia.controller.WriteObjectsToFile;
import com.cognixia.model.Customer;
import com.cognixia.model.Item;
import com.cognixia.model.ItemHistory;
import com.cognixia.view.Printing;

public class Main {
	

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
	
		ReadObjectsFromFile in = new ReadObjectsFromFile();
		WriteObjectsToFile out = new WriteObjectsToFile();
		
		Printing print = new Printing();
		Purchase purchase = new Purchase();
		Login login = new Login();
		Customer currentC = new Customer();
		
		Set<Customer> customers = new HashSet<Customer>();
		Map<Long,Set<ItemHistory>> allHistory = new HashMap<Long,Set<ItemHistory>>();
		Map<Long,Item> allItems = in.readFilefromTxt("src/main/resources/items.txt");

		customers.add(new Customer("Haley", "h", "hhhh1$"));
		
		boolean running = true;
		boolean loggedin = false;
		Long check = -1L;
		while(running) {
		if(loggedin) {
			for(Customer c: customers) {
				if(c.getId() == check) {
					currentC = c;
					System.out.println();
					System.out.println("--------Welcome Back, " + currentC.getName() + "--------");
					System.out.println();
					
					int choiceL = print.loginWelcomeMessage();
					
					switch(choiceL) {
					
					//purchase items
					case 1: 
						print.printItems(allItems);
						Set<ItemHistory> history = purchase.purchaseItems(allItems);
						allHistory.put(currentC.getId(), history);
				
						break;
					//return items
					case 2:
						Set <ItemHistory> currentHistory = allHistory.get(currentC.getId());
						for(ItemHistory i: currentHistory) {
							System.out.println(i);
						}	
						break;
					//view items	
					case 3:
						Set <ItemHistory> currentHistory2 = allHistory.get(currentC.getId());
						System.out.println("My Items");
						for(ItemHistory i: currentHistory2) {
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
