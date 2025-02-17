package smallITgroup.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString 
public class ItemDto {
	

	//description
	@EqualsAndHashCode.Include
	String id;                       // Unique identifier
	
    String nameItem;                 // Name of item
	String type;                     // Type of item
	String shelfId;

	//properties
	double volume;                   
	double weight;
	LocalDateTime bestBeforeDate;
	
//	custom constructor for creating item before placing
	public ItemDto(String id, String nameItem, String type, double volume, double weight,
			LocalDateTime bestBeforeDate) {
		super();
		this.id = id;
		this.nameItem = nameItem;
		this.type = type;
		this.volume = volume;
		this.weight = weight;
		this.bestBeforeDate = bestBeforeDate;
		this.shelfId = "";
	}



	public void setShelfId(String id) {
		// TODO Auto-generated method stub
		this.shelfId = id;
	}
	
	
	
	
	
}
