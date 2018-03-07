import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTests {

  Item item = null;
  
  @Before
  public void setUp() {
    item = new Item("Pen", 1, "$2.00");
  }
  
  @Test
  public void testNewItem() {
    // Edge Cases
    boolean thrown = false;
    try {
      new Item("Book", 0, "$1.00");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      new Item(null, 1, "$1.00");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      new Item("", 1, "$1.00");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      new Item("Book", 1, "$-100");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  
  @Test
  public void testGetItemDetails() {
    // Base Case
    assertEquals("Pen", item.getName());
    assertEquals(1, item.getQuantity());
    assertEquals("2.00", item.getPrice().toPlainString());

  }

  @Test
  public void testSetItemDetails() {
    // Setting invalid values
    boolean thrown = false;
    try {
      item.setQuantity(-1);
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      item.setName(null);
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

    thrown = false;
    try {
      item.setName("");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

    thrown = false;
    try {
      item.setPrice("$-1");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

  }
    
}
