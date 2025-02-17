package smallITgroup.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString 
public class ShelfDto {
	
	//description
	@EqualsAndHashCode.Include
	String id;                     // Unique identifier
	
	String itemsType;              // The type of items stored on this shelf
	Set<ItemDto> items;            // List of items placed on the shelf
	
	//properties
	double capacity;               // The total volume of the shelf that is allowed to accommodate items
	double currentCapacity;        // Current capacity of items
	double permittedWeight;        // Permissible weight of items placed on the shelf
	double currentWeight;          // Current weight of items placed on the shelf
	
	//notifications
	boolean warnings;              // Availability of shelf status warnings
    List<String> stateWarnings;    // Shelf status warnings
    
    // custom constructor
	public ShelfDto(String id, String itemsType, double capacity, double permittedWeight) {
		super();
		this.id = id;
		this.itemsType = itemsType;
		this.capacity = capacity;
		this.permittedWeight = permittedWeight;
		
		this.items = new HashSet<ItemDto>();
		this.currentCapacity = 0.0;
		this.currentWeight = 0.0;
		this.warnings = false;
		this.stateWarnings = new ArrayList<String>();
				
	}

	public void setItemsType(String itemsType) {
		this.itemsType = itemsType;
	}

	public void setItems(Set<ItemDto> items) {
		this.items = items;
	}

	public void setCurrentCapacity(double currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public void setWarnings(boolean warnings) {
		this.warnings = warnings;
	}

	public void setStateWarnings(List<String> stateWarnings) {
		this.stateWarnings = stateWarnings;
	}
    
    
  
}