package smallITgroup.appl;

import java.util.InputMismatchException;
import java.util.Scanner;

import smallITgroup.dto.HomeStorageDto;

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
	            	createStorage();	            	
	                break;
	            case 2:     
	            	manageShelvesMenu();	            	
	                break;
	            case 3:
	            	manageProductMenu();	            	
	                break;
	            case 4:
	            	monitorStorageMenu();	            	
	                break;
	            case 5:
	            	searchMenu();
	                break;
	            case 6:   
//	            	TODO Input storage object
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

	private static void createStorage() {
		System.out.println("Input storage name: ");
		String storageNameString = scanner.next();
		System.out.println("Input total storage volume(Ex. 1.2): ");
		double storageCapacity = 0;
		try {
			storageCapacity = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("Input Error! Try again. ");
		}
		
//		Create new object HomeStorageDto
		HomeStorageDto newHomeStorage = new HomeStorageDto(storageNameString, storageCapacity );
		
//		Save new storage	
		SavingData.saveStorageData(newHomeStorage);
	}

	private static void manageShelvesMenu() {
		System.out.println("""
				1. Add new shelf
				2. Remove shelf

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

	            	break;
	            case 2:   

	            	break;
	            case 0:
	            	System.out.println("/nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
	        }
		}
	}
	
	private static void manageProductMenu() {
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
	            	controller.itemNameSearch(itemName);
	            	break;
	            case 2:   
	            	System.out.println("Input product ID\n");
	            	String itemId = scanner.next();
	            	controller.itemIdSearch(itemId);
	            	break;
	            case 0:
	            	System.out.println("/nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
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
	            	System.out.println("\nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
	        }
		}
	}
	private static void chooseOptions() {
		System.out.println("""
				||Home Storage Menegement System (HSMS)||

				1. Create Storage
				2. Manage Shelves
				3. Items Management
				4. Inventory View
				5. Search
				6. Expiration Date Tracking
				
				0. Exit the application
				""");
		
	}
}
