import java.math.BigDecimal;

public class Item {

  private String name;
  private int quantity;
  private BigDecimal price;
  
  public Item(String name, int quantity, String price) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Product Name Cannot Be Empty.");
    }
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity should be greater than 0.");
    }
    price = price.replace(String.valueOf(price.charAt(0)), "");
    if (new BigDecimal(price).compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price should be greater than 0.");
    }
    
    this.name = name;
    this.quantity = quantity;
    this.price = new BigDecimal(price);
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Product Name Cannot Be Empty.");
    }
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity should be greater than 0.");
    }
    this.quantity = quantity;
  }
  
  public BigDecimal getPrice() {
    return price;
  }
  
  public void setPrice(String price) {
    price = price.replace(String.valueOf(price.charAt(0)), "");
    if (new BigDecimal(price).compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price should be greater than 0.");
    }
    this.price = new BigDecimal(price);
  }
  
}
