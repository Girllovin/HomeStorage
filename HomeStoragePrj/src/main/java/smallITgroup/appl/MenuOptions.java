package smallITgroup.appl;

import java.time.LocalDateTime;
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
	            	itemsManagementMenu();	            	
	                break;
	            case 4:
	            	showStorageMenu();	            	
	                break;
	            case 5:
	            	searchMenu();
	                break;
	            case 6:   
//	            	TODO Input storage object
	            	controller.checkGlobalWarnings(null);
	                break;

	            case 0:
	            	SavingDataController.saveStorageData(MainController.storage);
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
		System.out.println("Input storage height (lines quantity) : ");
		char height = (char) scanner.nextInt();
//		Create new object HomeStorageDto
		HomeStorageDto newHomeStorage = new HomeStorageDto(storageNameString, storageCapacity, height );
		
//		Save new storage	
		SavingDataController.saveStorageData(newHomeStorage);
		System.out.println(newHomeStorage);
	}

	private static void manageShelvesMenu() {
		System.out.println("""
				1. Create new shelf
				2. Change items type
				3. Remove shelf

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
//	            	TODO
//	            	Generated:
	            	//  (String id (Ex. A-1), 
	            	
	            	
//	            	User:
//	            	String itemsType, double capacity, double permittedWeight)
	            	
	            	break;
	            case 2:   
//	            	Calling function storageController/changeItemsType
	            	break;
	            case 3:   
//	            	Calling remove function
	            	break;
	            case 0:
	            	System.out.println("/nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
	        }
		}
	}
	
	private static void itemsManagementMenu() {
		System.out.println("""
				1. Put Item
				2. Take Item
				3. Replace Item

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
//	            	Generated:
//	            	(String id, 
	            	
//	            	User:
//	            	String nameItem, String type, double volume, double weight, LocalDateTime bestBeforeDate)
	            	break;
	            case 2:   
//	            	Show full storage
//	            	Input Item ID
	            
	            	break;
	            case 3:   
//	            	Show full storage
//	            	Input Item ID
//	            	Input new shelf number

	            	break;
	            case 0:
	            	System.out.println("/nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
	        }
		}			
	}	
	
	private static void showStorageMenu() {
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
//	            	TODO List of shelves and type of items
//	            	Input shelf number
//	            	Checking if the shelf does exist
	            	
	            	controller.showItemsOnTheShelf(shelfNumber);	            	            	
	            	return;
	            case 2:             	
	            	controller.showItemsInTheStorage(MainController.storage);
	            	return;

	            case 0:
	            	System.out.println("\nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
	        }
		}
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
	            	System.out.println("/nReturn to the main menu\n");
	                return;
	            default:
	                System.err.println("\nInvalid choice. Please try again.\n");
	        }
		}		
	}
	
	private static void chooseOptions() {
		System.out.println("""
				\n//Home Storage Menegement System (HSMS)//
				||Main menu||
				
				1. Create Storage
				2. Manage Shelves
				3. Items Management
				4. Show Storage
				5. Search Item
				6. Expiration Date Tracking
				
				0. Save and Exit
				""");		
	}
}
