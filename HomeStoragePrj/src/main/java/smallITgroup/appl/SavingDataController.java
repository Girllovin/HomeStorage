package smallITgroup.appl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import smallITgroup.dto.HomeStorageDto;
import smallITgroup.dto.ItemDto;
import smallITgroup.dto.ShelfDto;
import java.io.File;
import java.io.IOException;

public class SavingDataController {
	static ObjectMapper mapper = new ObjectMapper();

	// saving whole storage system into the file "target.Storage.json"
	// serialization
	public static boolean saveStorageData(HomeStorageDto storage) {
		try {
			mapper.registerModule(new JavaTimeModule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file = new File("target.Storage.json");
			mapper.writeValue(file, storage);
			System.out.println("Storage data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// saving item into the file "itemId.json"
	// serialization
	public static boolean saveItemData(ItemDto item) {
		mapper.registerModule(new JavaTimeModule());
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			File file = new File(item.getId() + ".json");
			mapper.writeValue(file, item);
			System.out.println("Item data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// saving shelf into the file "shelfId.json"
	// serialization
	public static boolean saveShelfData(ShelfDto shelf) {
		mapper.registerModule(new JavaTimeModule());
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			File file = new File(shelf.getId() + ".json");
			mapper.writeValue(file, shelf);
			System.out.println("Shelf data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public static ShelfDto restoreShelf(File file) {
		try {

			return mapper.readValue(file, ShelfDto.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static HomeStorageDto restoreStorage(File file) {
		try {

			return mapper.readValue(file, HomeStorageDto.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}