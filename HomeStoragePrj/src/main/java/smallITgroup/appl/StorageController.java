 package smallITgroup.appl;

import java.time.LocalDateTime;

import smallITgroup.dto.HomeStorageDto;
import smallITgroup.dto.ItemDto;
import smallITgroup.dto.ShelfDto;

public class StorageController {
	
	//Search for an item in the storage by ItemID	
	public static ItemDto findItemById(String itemId) {
		try {
			for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
				for(ItemDto item : shelf.getItems()) {
					if (item.getId().equals(itemId)) {
					   return item;	
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//Search for an item in the storage by name of the item	
	public static ItemDto findItemByName(String itemName) {
		try {
			for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
				for(ItemDto item : shelf.getItems()) {
					if (item.getNameItem().equals(itemName)) {
					   return item;	
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ShelfDto findShelfById(String shelfId) {
		
		try {
			for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
					if (shelf.getId().equals(shelfId)) {
						return shelf;	
					}
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}


	public static void showItemsOnTheShelf(String shelfId) {

		// TODO
	}

	public static void showItemsInTheStorage(String storageName) {

		// TODO
	}
    
	public static boolean itemPlacement(ItemDto item, ShelfDto shelf) {
		
		try {
			if (((shelf.getCapacity() - shelf.getCurrentCapacity())> item.getVolume()) ||
					((shelf.getCurrentWeight() + item.getWeight()) < shelf.getPermittedWeight())) {
				if (item.getBestBeforeDate().plusDays(3).isBefore(LocalDateTime.now())) {
					item.setShelfId(shelf.getId());	
					shelf.getItems().add(item);
					
					return true;
				} System.out.println("\nItem " + item.getNameItem() + " is expired! \n "
						+ "Remove the item from the storage!!! \n " );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public static ShelfDto findShelfForItem(ItemDto item) {
		
		ShelfDto destinationShelf = new ShelfDto();
		if (MainController.storage.getItemsTypeList().contains(item.getType())) {
			for (ShelfDto shelf :MainController.storage.getPlacingShelf()){
				if (shelf.getItemsType().equalsIgnoreCase(item.getType())){
					if (destinationShelf.getItemsType().equalsIgnoreCase(null)||
							(((destinationShelf.getCurrentCapacity() < shelf.getCapacity())&&
							((shelf.getCapacity() - shelf.getCurrentCapacity())> item.getVolume()))) || 
							((shelf.getCurrentWeight() + item.getWeight()) < shelf.getPermittedWeight())) {
						destinationShelf = shelf;
					}
				}
			}
		} else {
			destinationShelf = MainController.nextShelf;
		}
				
		return destinationShelf;
		
	}
	
	public static boolean takeItem(String itemId) {
		
		try {
			ItemDto item = findItemById(itemId);
			ShelfDto destinationShelf = findShelfById(item.getShelfId());
			for (ShelfDto sourceShelf : MainController.storage.getPlacingShelf()) {
				if (sourceShelf.equals(destinationShelf)) {
					if (sourceShelf.getItems().remove(item)) {
						return true;
					}
					System.out.println("Failed to take item");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean replaceItem(String itemId, String shelfId) {

		// TODO
		return false;
		
	}
	
	public static ShelfDto checkWarnings(ShelfDto shelf) {

		// TODO
		return shelf;
		
	}
	
	public static HomeStorageDto checkGlobalWarnings(HomeStorageDto storage) {

		// TODO
		return storage;
		
	}
	
	
	
}
