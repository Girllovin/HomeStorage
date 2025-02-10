package smallITgroup.models;

import java.util.List;

public class Homestorage {
	//description
		String storageNameString;      // Name of storage room
		List<String> itemsTypeList;    // List of items placed in the storage
		List<Shelf> placingShelf;   // List of shelfs in the storage
		
		//characteristics
		double storageCapacity;        // Total storage capacity
		double currentFreeStorageCapacity; // Current free space in the storage
		
		//notifications
		boolean warnings;              // Availability of storage status warnings
	    List<String> stateWarnings;    // Storage status warnings
}
