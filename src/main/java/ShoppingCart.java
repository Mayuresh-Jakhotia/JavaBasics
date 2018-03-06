import java.util.ArrayList;

public class ShoppingCart {
  
  private ArrayList<Item> items;
  
  public ShoppingCart() {
    this.items = new ArrayList<Item>();    
  }
  
  public void addToCart(Item item) {
    this.items.add(item);
  }
  
  public void removeFromCart(Item item) {
    this.items.remove(item);
  }

  public ArrayList<Item> getItems() {
    return this.items;
  }
  
  
}
