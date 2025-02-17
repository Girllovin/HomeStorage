package smallITgroup.appl;


import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import smallITgroup.dto.HomeStorageDto;
import smallITgroup.dto.ItemDto;
import smallITgroup.dto.ShelfDto;

public class MainController {
	static HomeStorageDto storage;
	static ShelfDto nextShelf; 
	
	static char lineCounter = 'A';
	static int shelfCounter = 0;
	static int counterItem = 0;
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {	
		lineCounter++;		
		ItemDto item1 = new ItemDto("First item", "Chair", "Furniture", "A2", 2.2, 1.7, LocalDateTime.now()) ;
		SavingDataController.saveItemData(item1);
		ItemDto item2 = new ItemDto("Second item", "Watermelon", "Food", "A1", 1.05, 2.10, LocalDateTime.now()) ;
		SavingDataController.saveItemData(item2);
		ItemDto item3 = new ItemDto("Third item","Hammer", "Instruments", "A1", 17.12, 8.17, LocalDateTime.now()) ;
		SavingDataController.saveItemData(item3);
		Set<ItemDto> items = new HashSet<ItemDto>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		List<String> warnings = new ArrayList<String>();
		
		
		ShelfDto shelf1 = new ShelfDto("Shelf" + ++shelfCounter, "Everything", items, 500.0, 500.0, 100.0, 0.0, false, warnings );
		SavingDataController.saveShelfData(shelf1);
		
		ItemDto item4 = new ItemDto("Forth item","Scooter", "Sport", "A1", 40.12, 11.15, LocalDateTime.now()) ;
		SavingDataController.saveItemData(item4);
		ItemDto item5 = new ItemDto("Fifth item", "Bread", "Food", "A1", 0.5, 1.10, LocalDateTime.now()) ;
		SavingDataController.saveItemData(item5);
		ItemDto item6 = new ItemDto("Sixth item","Skateboard", "Sport", "A1", 7.12, 4.07, LocalDateTime.now()) ;
		SavingDataController.saveItemData(item6);
		Set<ItemDto> items2 = new HashSet<ItemDto>();
		items2.add(item4);
		items2.add(item5);
		items2.add(item6);
		
		ShelfDto shelf3 = new ShelfDto("Shelf" + ++shelfCounter, "Everything", items2, 500, 500, 100, 0, false, warnings );
		SavingDataController.saveShelfData(shelf3);
		
		List<ShelfDto> shelfs = new ArrayList<ShelfDto>();
		shelfs.add(shelf1);
		shelfs.add(shelf3);
		HomeStorageDto homeStorage = new HomeStorageDto("Our storage room", warnings, shelfs, 2000, 0, false, warnings);
		SavingDataController.saveStorageData(homeStorage);
		
		
		File file = new File("src\\Files\\Shelf1.json");
		File file2 = new File("src\\\\Files\\\\Shelf2.json");
		File file3 = new File("src\\Files\\target.Storage.json");
		
		ShelfDto shelf2 = SavingDataController.restoreShelf(file);
		System.out.println(shelf2);
		ShelfDto shelf4 = SavingDataController.restoreShelf(file2);
		System.out.println(shelf4);
		HomeStorageDto homeStorage1 = SavingDataController.restoreStorage(file3);
		System.out.println(homeStorage1);	
		
//		Menu option
		MenuOptions menu = new MenuOptions();
		menu.menu();
	}	
}
