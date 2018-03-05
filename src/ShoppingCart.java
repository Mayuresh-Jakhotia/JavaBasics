import java.math.BigDecimal;

public class ShoppingCart {
  
  private String productName;
  private int quantity;
  private BigDecimal price;
  
  public ShoppingCart(String productName, int quantity, String price) {
    if (productName == null || productName.equals("")) {
      throw new IllegalArgumentException("Product Name Cannot Be Empty.");
    }
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity should be greater than 0.");
    }
    price = price.replace(String.valueOf(price.charAt(0)), "");
    if (new BigDecimal(price).compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price should be greater than 0.");
    }
    
    this.productName = productName;
    this.quantity = quantity;
    this.price = new BigDecimal(price);
  }
  
  public String getProductName() {
    return productName;
  }
  
  public void setProductName(String productName) {
    if (productName == null || productName.equals("")) {
      throw new IllegalArgumentException("Product Name Cannot Be Empty.");
    }
    this.productName = productName;
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
