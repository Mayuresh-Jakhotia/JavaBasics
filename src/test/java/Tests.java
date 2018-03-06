import org.junit.*;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Tests extends TestCase {

  @Test
  public void testEncode() {
    Solution solution = new Solution();

    // Base Cases
    assertEquals("P", solution.encode("Public"));
    assertEquals("X", solution.encode("Private"));
    assertEquals("V", solution.encode("View"));
    assertEquals("I", solution.encode("Inherit"));

    // Irrespective of Case
    assertEquals("I", solution.encode("inhERit"));

    // Edge Cases
    boolean thrown=false;
    try {
    solution.encode(null);
    }
    catch(NullPointerException n) {
      thrown = true;
    }
    assertTrue(thrown);
    
    assertEquals("Invalid string to encode", solution.encode("-1"));
    assertEquals("Invalid string to encode", solution.encode(""));
  }

  @Test
  public void testDecode() {
    Solution solution = new Solution();

    // Base Cases
    assertEquals("Public", solution.decode("P"));
    assertEquals("Private", solution.decode("X"));
    assertEquals("View", solution.decode("V"));
    assertEquals("Inherit", solution.decode("I"));

    // Irrespective of Case
    assertEquals("Inherit", solution.decode("i"));

    // Edge Cases
    boolean thrown = false;
    try {
    solution.decode(null);
    }
    catch(NullPointerException n) {
      thrown = true;
    }
    assertTrue(thrown);
    
    assertEquals("Invalid string to decode", solution.decode("-1"));
    assertEquals("Invalid string to decode", solution.decode(""));
  }

  @Test
  public void testShoppingCart() { 
    ShoppingCart shoppingCart = new ShoppingCart();
    
    // Try getting items before adding anything to cart
    assertEquals("[]", shoppingCart.getItems().toString());
    
    // Add some items
    Item item1 = new Item("Book", 1, "$1.00");
    Item item2 = new Item("Pen", 1, "$2.0");
    
    shoppingCart.addToCart(item1);
    shoppingCart.addToCart(item2);
    
    shoppingCart.removeFromCart(item1);    
    // Removing same element again shouldn't cause an error
    shoppingCart.removeFromCart(item1);
    
    shoppingCart.removeFromCart(item2);
    
    assertEquals(0, shoppingCart.getItems().size());
  }
  
  @Test
  public void testItem() {
    Item item = new Item("Pen", 1, "$2.00");

    // Base Case
    assertEquals("Pen", item.getName());
    assertEquals(1, item.getQuantity());
    assertEquals("2.00", item.getPrice().toPlainString());
    
    // Edge Cases
    boolean thrown = false;
    try {
      new Item("Book", 0, "$1.00");
      new Item(null, 1, "$1.00");
      new Item("", 1, "$1.00");
      new Item("Book", 1, "$-100");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

    // Setting invalid values
    thrown = false;
    try {
      item.setQuantity(-1);
      item.setName(null);
      item.setName("");
      item.setPrice("$-1");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

  }
  
  @Test
  public void testDiscountSum() {
    Solution solution = new Solution();
    
    ShoppingCart shoppingCart = new ShoppingCart();

    shoppingCart.addToCart(new Item("Book", 1, "$1.00"));
    shoppingCart.addToCart(new Item("Pen", 1, "$2.0"));

    // Base Case
    assertEquals("$2.96", solution.discountSum(shoppingCart));
       
    // Edge Case
    shoppingCart.getItems().clear();
    
    assertEquals("$0.00", solution.discountSum(shoppingCart));
  }

  public static void main(String[] args) {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Tests.class);
    TestRunner.run(suite);
  }
}
