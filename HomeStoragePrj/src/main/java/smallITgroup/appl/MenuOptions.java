package smallITgroup.appl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOptions {
	static Scanner scanner = new Scanner(System.in);
	static StorageController controller = new StorageController();
	public static void menu(){		
		while (true) {
			chooseOptions();
			int choice;
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.err.println("Input Error! Try again.");
				scanner.nextLine(); 
				continue;
			}		
	        switch (choice) {
	            case 1:
	            	monitorStorageMenu();
	                break;
	            case 2:     
	            	searchMenu();
	                break;
	            case 3:
	            	manageShelvesMenu();
	                break;
	            case 4:
	            	manageProductMenu();
	                break;
	            case 5:
	            	organizeStorage();
	                break;
	            case 6:   
//	            	TODO Input storage name
	            	controller.checkGlobalWarnings(null);
	                break;

	            case 0:
	            	System.out.println("__________________\nApplication closed");
	                scanner.close();
	                System.exit(0);
	                return;
	            default:
	                System.out.println("\nInvalid choice. Please try again.\n");
	        }
		}	
	}	

	private static void organizeStorage() {
		// TODO Auto-generated method stub
		
	}

	private static void manageProductMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void manageShelvesMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void searchMenu() {
		System.out.println("""
				1. Search by Name
				2. Search by ID

				0. Main menu
				""");
		while (true) {
			int choice;
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.err.println("Input Error! Try again.");
				scanner.nextLine(); 
				continue;
			}		
	        switch (choice) {
	            case 1:  
	            	System.out.println("Input product name\n");
	            	String itemName = scanner.next();
	            	controller.findItemByName(itemName);
	            	break;
	            case 2:   
	            	System.out.println("Input product ID\n");
	            	String itemId = scanner.next();
	            	controller.findItemById(itemId);
	            	break;
	            case 0:
	            	System.out.println("Return to the main menu\n");
	                return;
	            default:
	                System.out.println("\nInvalid choice. Please try again.\n");
	        }
		}
		
	}

	private static void monitorStorageMenu() {
		System.out.println("""
				1. Show Items on the shelf
				2. Show full storage

				0. Main menu
				""");
		while (true) {
			int choice;
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.err.println("Input Error! Try again.");
				scanner.nextLine(); 
				continue;
			}		
	        switch (choice) {
	            case 1:
	            	System.out.println("Input shelf number: ");
	            	String shelfNumber = scanner.next();
	            	
//	            	TODO Checking if the shelf does exist
	            	controller.showItemsOnTheShelf(shelfNumber);	            	            	
	            	return;
	            case 2:   
//	            	TODO Correct storageName
	            	String storageName = "Default name";
	            	controller.showItemsInTheStorage(storageName);
	            	return;

	            case 0:
	            	System.out.println("Return to the main menu\n");
	                return;
	            default:
	                System.out.println("\nInvalid choice. Please try again.\n");
	        }
		}
	}
	private static void chooseOptions() {
		System.out.println("""
				||Home Storage Menegement System (HSMS)||

				1. Inventory View
				2. Search
				3. Manage Shelves
				4. Product Management
				5. Organize Storage
				6. Expiration Date Tracking
				
				0. Exit the application
				""");
		
	}
}
