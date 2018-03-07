import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class SolutionTests {

  Solution solution = null;
  
  @Mock
  ShoppingCart shoppingCart;
  
  @Mock
  Item item1;

  @Mock
  Item item2;
  
  @Rule public MockitoRule rule = MockitoJUnit.rule();
  
  @Before
  public void setUp() {
    solution = new Solution();
  }

  @Test
  public void testEncode() {
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
  public void testDiscountSum() {
    BigDecimal price1 = new BigDecimal("2.00");
    BigDecimal price2 = new BigDecimal("1.00");
    
    // Create ArrayList of items to return to shoppingCart.getItems()
    ArrayList<Item> items = new ArrayList<>();
    items.add(item1);
    items.add(item2);

    // shoppingCart.getItems() and item.getPrice() are used in Solution's discountSum method. So defining their behavior.
    when(shoppingCart.getItems()).thenReturn(items);
    when(item1.getPrice()).thenReturn(price1);
    when(item2.getPrice()).thenReturn(price2);
    assertEquals("$2.96", solution.discountSum(shoppingCart));
    
    // Verifying getItems() was called only once.
    verify(shoppingCart, times(1)).getItems();
    
    // Clearing all items from cart
    shoppingCart.getItems().clear();    
    assertEquals("$0.00", solution.discountSum(shoppingCart));
  }  
  
}