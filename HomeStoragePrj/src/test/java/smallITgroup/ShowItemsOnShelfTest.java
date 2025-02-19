package smallITgroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import smallITgroup.appl.MainController;
import smallITgroup.appl.StorageController;
import smallITgroup.dto.HomeStorageDto;
import smallITgroup.dto.ItemDto;
import smallITgroup.dto.ShelfDto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShowItemsOnShelfTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        // Redirect console output to capture printed text for testing
        System.setOut(new PrintStream(outputStreamCaptor));
        
    }

    // ✅ Test 1: Shelf with Items
    @Test
    void testShowItemsOnShelf_WithItems() {
        // Mock shelf
        ShelfDto shelf = new ShelfDto();
        shelf.setId("SHELF123");
        shelf.setItemsType("Electronics");

        // Mock items
        ItemDto item1 = new ItemDto("101", "Smartphone", null, 0, 0, LocalDateTime.now());
        ItemDto item2 = new ItemDto("102", "Laptop", null, 0, 0, LocalDateTime.now());
        HashSet<ItemDto> itemsSet = new HashSet<ItemDto>();
        itemsSet.add(item1);
        itemsSet.add(item2);
        
        shelf.setItems(itemsSet);

       
      
        when(StorageController.findShelfById("SHELF123")).thenReturn(shelf);

        // Call function
        StorageController.showItemsOnTheShelf("SHELF123");

        // Expected output
        String expectedOutput = """
                Shelf ID: SHELF123 | Type: Electronics
                - 101: Smartphone
                - 102: Laptop""";

        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput.trim()));
    }

    // ✅ Test 2: Shelf Exists but is Empty
    @Test
    void testShowItemsOnShelf_EmptyShelf() {
        // Mock empty shelf
        ShelfDto shelf = new ShelfDto();
        shelf.setId("SHELF_EMPTY");
        shelf.setItemsType("Books");
        shelf.setItems(new HashSet<ItemDto>()); // No items

       
        when(StorageController.findShelfById("SHELF_EMPTY")).thenReturn(shelf);

        // Call function
        StorageController.showItemsOnTheShelf("SHELF_EMPTY");

        // Expected output
        String expectedOutput = """
                Shelf ID: SHELF_EMPTY | Type: Books
                (No items on this shelf)""";

        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput.trim()));
    }

    // ❌ Test 3: Shelf Not Found
    @Test
    void testShowItemsOnShelf_ShelfNotFound() {
    	
        when(StorageController.findShelfById("INVALID_ID")).thenReturn(null);

        // Call function
        StorageController.showItemsOnTheShelf("INVALID_ID");

        // Expected error output
        String expectedOutput = "Error: Shelf with ID 'INVALID_ID' not found.";

        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput));
    }

    // ❌ Test 4: Shelf Exists but getItems() is Null
    @Test
    void testShowItemsOnShelf_ItemsListIsNull() {
        // Mock shelf with null item list
        ShelfDto shelf = new ShelfDto();
        shelf.setId("NULL_ITEMS");
        shelf.setItemsType("Furniture");
        shelf.setItems(null);  // Null items list

        
        when(StorageController.findShelfById("NULL_ITEMS")).thenReturn(shelf);

        // Call function
        StorageController.showItemsOnTheShelf("NULL_ITEMS");

        // Expected output
        String expectedOutput = """
                Shelf ID: NULL_ITEMS | Type: Furniture
                (No items on this shelf)""";

        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput.trim()));
    }
}
