import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

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
  
  public String discountSum(ArrayList<ShoppingCart> shoppingCart) {
    BigDecimal totalPrice = BigDecimal.ZERO;
    BigDecimal discount = new BigDecimal("0.02");
    for(ShoppingCart item: shoppingCart) {
      totalPrice = totalPrice.add(item.getPrice().subtract(discount));
    }
    return NumberFormat.getCurrencyInstance().format(totalPrice);
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.encode("Public"));
    System.out.println(solution.decode("x"));
    
    ArrayList<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
    shoppingCart.add(new ShoppingCart("Book", 1, "$1.00"));
    shoppingCart.add(new ShoppingCart("Pen", 1, "$2.0"));

    System.out.println(solution.discountSum(shoppingCart));
  }

}
