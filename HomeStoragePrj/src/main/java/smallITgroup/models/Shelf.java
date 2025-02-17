package smallITgroup.models;

import java.util.List;


public class Shelf {

	//description
		String Id;                     // Unique identifier
		String itemsType;              // The type of items stored on this shelf
		List<Item> items;              // List of items placed on the shelf
		
		//properties
		double capacity;               // The total volume of the shelf that is allowed to accommodate items
		double currentCapacity;        // Current free capacity
		double permittedWeight;        // Permissible weight of items placed on the shelf
		double currentWeight;          // Current weight of items placed on the shelf
		
		//notifications
		boolean warnings;              // Availability of shelf status warnings
	    List<String> stateWarnings;    // Shelf status warnings
}
