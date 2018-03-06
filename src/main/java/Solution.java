import java.math.BigDecimal;
import java.text.NumberFormat;

public class Solution {
  
  public String encode(String input) {
    if (input == null) {
      throw new NullPointerException("Input string is null");
    }
    switch(input.toLowerCase()) {
      case "public":
        return "P";
  
      case "private":
        return "X";
        
      case "view":
        return "V";
      
      case "inherit":
        return "I";
    }
    
    return "Invalid string to encode";
  }

  public String decode(String input) {
    if (input == null) {
      throw new NullPointerException("Input string is null");
    }
    switch(input.toLowerCase()) {
      case "p":
        return "Public";
  
      case "x":
        return "Private";
        
      case "v":
        return "View";
      
      case "i":
        return "Inherit";
    }
    
    return "Invalid string to decode";
  }
  
  public String discountSum(ShoppingCart shoppingCart) {
    BigDecimal totalPrice = BigDecimal.ZERO;
    BigDecimal discount = new BigDecimal("0.02");
    for(Item item: shoppingCart.getItems()) {
      totalPrice = totalPrice.add(item.getPrice().subtract(discount));
    }
    return NumberFormat.getCurrencyInstance().format(totalPrice);
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.encode("Public"));
    System.out.println(solution.decode("x"));
    
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addToCart(new Item("Book", 1, "$1.00"));
    shoppingCart.addToCart(new Item("Pen", 1, "$2.0"));

    System.out.println(solution.discountSum(shoppingCart));
  }

}
