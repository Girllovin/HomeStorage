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
@EqualsAndHashCode
@ToString 
public class ItemDto {
	

	//description
	String id;                       // Unique identifier
    String nameItem;                 // Name of item
	String type;                     // Type of item
	String shelfId;

	//properties
	double volume;                   
	double weight;
	LocalDateTime bestBeforeDate;
	
	
	
	
}
