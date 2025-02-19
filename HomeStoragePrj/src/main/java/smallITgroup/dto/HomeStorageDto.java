package smallITgroup.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString 

public class HomeStorageDto {
	
	//description
	@EqualsAndHashCode.Include
	String storageNameString;          // Name of storage room
	
	List<String> itemsTypeList;        // List of items placed in the storage
	List<ShelfDto> placingShelf;       // List of shelfs in the storage
	
	//characteristics
	double storageCapacity;            // Total storage capacity
	double currentFreeStorageCapacity; // Current volume of items in storage
	char height;					   // Quantity of lines in storage
	int lenght;
	
	//notifications
	boolean warnings;                  // Availability of storage status warnings
    List<String> stateWarnings;        // Storage status warnings
    
    //custom constructor
	public HomeStorageDto(String storageNameString, double storageCapacity, char height, int lenght) {
		super();
		this.storageNameString = storageNameString;
		this.storageCapacity = storageCapacity;
		this.height = (char) (height + 64) ;
		this.lenght = lenght;
		this.itemsTypeList = new ArrayList<String>();
		this.placingShelf = new ArrayList<ShelfDto>();
		this.currentFreeStorageCapacity = 0.0;
		this.warnings = false;
		this.stateWarnings = new ArrayList<String>();
		
	}

	public void setItemsTypeList(List<String> itemsTypeList) {
		this.itemsTypeList = itemsTypeList;
	}

	public void setPlacingShelf(List<ShelfDto> placingShelf) {
		this.placingShelf = placingShelf;
	}

	public void setStateWarnings(List<String> stateWarnings) {
		this.stateWarnings = stateWarnings;
	}	
	
	
}
