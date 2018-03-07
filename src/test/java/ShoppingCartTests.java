import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ShoppingCartTests {
  
  ShoppingCart shoppingCart = null;
 
  @Mock
  Item item;

  @Rule public MockitoRule rule = MockitoJUnit.rule();
  
  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
  }

  @Test
  public void testEmptyCart() {
    assertEquals("[]", shoppingCart.getItems().toString());    
  }

  @Test
  public void testAddToCart() {    
    shoppingCart.addToCart(item);
    shoppingCart.addToCart(item);
    assertEquals(2, shoppingCart.getItems().size());
  }

  @Test
  public void testRemoveFromCart() {
    shoppingCart.removeFromCart(item);
    shoppingCart.removeFromCart(item);   
    shoppingCart.removeFromCart(item);
    assertEquals(0, shoppingCart.getItems().size());    
  }
  
}
