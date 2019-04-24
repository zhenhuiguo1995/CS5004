package edu.neu.ccs.cs5004;

public abstract class Item {

  protected AbstractProduct product;
  protected int quantity;

  /**
   * Instantiates a new item.
   *
   * @param product the product
   * @param quantity the quantity
   */
  public Item(AbstractProduct product, int quantity) {
    this.product = product;
    this.quantity = quantity;
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

  /**
   * @param obj -- object to be compared.
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(this.getClass())) {
      return false;
    }
    obj = (Item) obj;
    return this.getProduct().equals(((Item) obj).getProduct())
        && this.getQuantity() == ((Item) obj).getQuantity();
  }

  /**
   * override hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Gets Item price.
   *
   * @return the price
   */
  public double getItemPrice() {
    return this.getProduct().getPrice() * this.getQuantity();
  }
}
