package edu.neu.ccs.cs5004;

import java.util.LinkedList;
import java.util.List;

/**
 * This represents the result of the method fulfill order.
 */
public class FulfillOrderResult {

  private List<Item> removedProducts;
  private List<Item> outOfStockProducts;

  public FulfillOrderResult() {
    this.removedProducts = new LinkedList<>();
    this.outOfStockProducts = new LinkedList<>();
  }

  /**
   * Add a record in the removed products list.
   *
   * @param removedProduct the removed product
   */
  public void addRemovedProduct(Item removedProduct) {
    removedProducts.add(removedProduct);
  }

  /**
   * The add a record in the out of stock products list.
   *
   * @param outOfStockProduct the out of stock product
   */
  public void addOutOfStockProduct(Item outOfStockProduct) {
    outOfStockProducts.add(outOfStockProduct);
  }

  /**
   * Get the removed products.
   *
   * @return the removed products
   */
  public List<Item> getRemovedProducts() {
    return this.removedProducts;
  }

  /**
   * Get the out of stock products.
   *
   * @return the out of stock products
   */
  public List<Item> getOutOfStockProducts() {
    return this.outOfStockProducts;
  }


}
