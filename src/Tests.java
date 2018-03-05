import java.util.ArrayList;

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
    ShoppingCart shoppingCart = new ShoppingCart("Pen", 1, "$2.00");

    // Base Case
    assertEquals("Pen", shoppingCart.getProductName());
    assertEquals(1, shoppingCart.getQuantity());
    assertEquals("2.00", shoppingCart.getPrice().toPlainString());
    
    // Edge Cases
    boolean thrown = false;
    try {
      new ShoppingCart("Book", 0, "$1.00");
      new ShoppingCart(null, 1, "$1.00");
      new ShoppingCart("", 1, "$1.00");
      new ShoppingCart("Book", 1, "$-100");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

    // Setting invalid values
    thrown = false;
    try {
      shoppingCart.setQuantity(-1);
      shoppingCart.setProductName(null);
      shoppingCart.setProductName("");
      shoppingCart.setPrice("$-1");
    }
    catch(IllegalArgumentException n) {
      thrown = true;
    }
    assertTrue(thrown);

  }
  
  @Test
  public void testDiscountSum() {
    Solution solution = new Solution();
    ArrayList<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();

    shoppingCart.add(new ShoppingCart("Book", 1, "$1.00"));
    shoppingCart.add(new ShoppingCart("Pen", 1, "$2.0"));

    // Base Case
    assertEquals("$2.96", solution.discountSum(shoppingCart));
       
    // Edge Case
    shoppingCart.clear();
    assertEquals("$0.00", solution.discountSum(shoppingCart));
     
  }

  public static void main(String[] args) {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Tests.class);
    TestRunner.run(suite);
  }
}
