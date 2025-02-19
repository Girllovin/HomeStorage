package smallITgroup.appl;

import java.time.LocalDateTime;

import smallITgroup.dto.HomeStorageDto;
import smallITgroup.dto.ItemDto;
import smallITgroup.dto.ShelfDto;

public class StorageController {

	// Search for an item in the storage by ItemID
	public static ItemDto findItemById(String itemId) {
		try {
			for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
				for (ItemDto item : shelf.getItems()) {
					if (item.getId().equals(itemId)) {
						return item;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error finding item by ID: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	// Search for an item in the storage by name of the item
	public static ItemDto findItemByName(String itemName) {
		if (itemName == null || itemName.isEmpty()) {
			System.err.println("Error: Empty or null item name provided.");
			return null;
		}
		try {
			for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
				for (ItemDto item : shelf.getItems()) {
					if (item.getNameItem().equals(itemName)) {
						return item;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error finding item by name: " + e.getMessage());
		}

		return null;
	}

	// Search for a shelf by ID
	public static ShelfDto findShelfById(String shelfId) {

		try {
			for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
				if (shelf.getId().equals(shelfId)) {
					return shelf;
				}
			}
		} catch (Exception e) {
			System.err.println("Error finding shelf by ID: " + e.getMessage());
		}
		return null;
	}

	public static void showItemsOnTheShelf(String shelfId) {

		// TODO
	}

	public static void showItemsInTheStorage(HomeStorageDto homeStorage) {

		// TODO
	}

	// Place an item on a shelf
	public static boolean itemPlacement(ItemDto item, ShelfDto shelf) {

		{
			if (item == null || shelf == null) {
				System.err.println("Error: Null item or shelf provided to itemPlacement.");
				return false;
			}
			try {
				if (((shelf.getCapacity() - shelf.getCurrentCapacity()) > item.getVolume())
						|| ((shelf.getCurrentWeight() + item.getWeight()) < shelf.getPermittedWeight())) {
					if (item.getBestBeforeDate().plusDays(3).isBefore(LocalDateTime.now())) {
						item.setShelfId(shelf.getId());
						shelf.getItems().add(item);

						return true;
					}
					System.out.println("\nItem " + item.getNameItem() + " is expired! \n "
							+ "Remove the item from the storage!!! \n ");
				}
			} catch (Exception e) {
				System.err.println("Error placing item: " + e.getMessage());
			}
		}

		return false;
	}

	// Find the best shelf for an item
	public static ShelfDto findShelfForItem(ItemDto item) {
		if (item == null) {
			System.err.println("Error: Null item provided to findShelfForItem.");
			return null;
		}

		ShelfDto destinationShelf = new ShelfDto();
		try {
			if (MainController.storage.getItemsTypeList().contains(item.getType())) {
				for (ShelfDto shelf : MainController.storage.getPlacingShelf()) {
					if (shelf.getItemsType().equalsIgnoreCase(item.getType())) {
						if (destinationShelf.getItemsType().equalsIgnoreCase(null)
								|| (((destinationShelf.getCurrentCapacity() < shelf.getCapacity())
										&& ((shelf.getCapacity() - shelf.getCurrentCapacity()) > item.getVolume())))
								|| ((shelf.getCurrentWeight() + item.getWeight()) < shelf.getPermittedWeight())) {
							destinationShelf = shelf;
						}
					}
				}
			} else {
				destinationShelf = MainController.nextShelf;
			}
		} catch (Exception e) {
			System.err.println("Error finding shelf for item: " + e.getMessage());
		}

		return destinationShelf;

	}

	// Remove an item from a shelf
	public static boolean takeItem(String itemId) {
		if (itemId == null || itemId.isEmpty()) {
			System.err.println("Error: Empty or null itemId provided.");
			return false;
		}

		try {
			ItemDto item = findItemById(itemId);
			if (item == null) {
				System.err.println("Error: Item not found.");
				return false;
			}
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
			System.err.println("Error while taking item: " + e.getMessage());
			e.printStackTrace();
		}

		return false;

	}

	// Move an item to a different shelf
	public static boolean replaceItem(String itemId, String shelfId) {
		if (itemId == null || itemId.isEmpty() || shelfId == null || shelfId.isEmpty()) {
			System.err.println("Error: Empty or null itemId or shelfId provided.");
			return false;
		}

		try {
			if (itemPlacement(findItemById(itemId), findShelfById(shelfId))) {
				takeItem(itemId);
			}
		} catch (Exception e) {
			System.err.println("Error replacing item: " + e.getMessage());

		}

		return false;

	}

	// Check for expired items and current parameters on a shelf
	public static ShelfDto checkWarnings(ShelfDto shelf) {
		if (shelf == null) {
			System.err.println("Error: Null shelf provided to checkWarnings.");
			return null;
		}
		try {
			for (ItemDto item : shelf.getItems()) {
				if (item.getBestBeforeDate().plusDays(1).isBefore(LocalDateTime.now())) {
					shelf.getStateWarnings()
							.add(" Item " + item.getNameItem() + " - " + item.getId() + " is out of date!!!\n");
				}
			}
		} catch (Exception e) {
			System.err.println("Error checking shelf warnings: " + e.getMessage());
			e.printStackTrace();
		}

		return shelf;

	}
	
    //	Check for expired items and current parameters in the storage
	public static HomeStorageDto checkGlobalWarnings(HomeStorageDto storage) {

		if (storage == null) {
			System.err.println("Error: Null storage provided to checkWarnings.");
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		String storageWarning;
		try {
			for (ShelfDto shelf : storage.getPlacingShelf()) {
				if (shelf.getStateWarnings() != null) {
					for (String warning: shelf.getStateWarnings()) {
						storageWarning = shelf.getId() + " " + warning;
						storage.getStateWarnings().add(storageWarning);
						builder.append("\n ").append(storageWarning);
					}					
				}
			}
			System.out.println(builder);
		} catch (Exception e) {
			System.err.println("Error checking storage warnings: " + e.getMessage());
			e.printStackTrace();
		}
		return storage;

	}

}
