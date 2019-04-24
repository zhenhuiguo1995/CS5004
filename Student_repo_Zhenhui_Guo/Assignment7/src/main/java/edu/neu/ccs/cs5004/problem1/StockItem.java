package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a stock item, including product and quantity.
 */
public class StockItem {
  private AbstractProduct product;
  private int quantity;

  /**
   * Instantiates a new Stock item.
   *
   * @param product the product
   * @param quantity the quantity
   */
  public StockItem(AbstractProduct product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public boolean checkItem(int purchaseNumber) {
    return this.quantity >= purchaseNumber;
  }

  public boolean reduceQuantity(int purchaseNumber) {
    if (!checkItem(purchaseNumber)) {
      return false;
    } else {
      this.quantity -= purchaseNumber;
      return true;
    }
  }

  /**
   * Gets product.
   *
   * @return the product
   */
  public AbstractProduct getProduct() {
    return product;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets product.
   *
   * @param product the product
   */
  public void setProduct(AbstractProduct product) {
    this.product = product;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
