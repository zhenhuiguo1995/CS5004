package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * Represents details of a receipt.
 */

public class Receipt {

  private double totalPrice;
  private List<Item> receivedProduct;
  private List<Item> outOfStockProduct;
  private List<Item> removedProduct;

  /**
   * Instantiates a new receipt.
   *
   * @param receivedProduct - receivedProduct list
   * @param outOfStockProduct - outOfStockProduct list
   * @param removedProduct - removedProduct list
   */
  public Receipt(List<Item> receivedProduct, List<Item> outOfStockProduct,
      List<Item> removedProduct) {
    this.receivedProduct = receivedProduct;
    this.outOfStockProduct = outOfStockProduct;
    this.removedProduct = removedProduct;
    this.totalPrice = calculatePrice();
  }

  /**
   * Add new product and quantity into the receivedProduct list.
   *
   * @param item -- Item
   */
  public void addReceivedProduct(Item item) {
    this.receivedProduct.add(item);
  }

  /**
   * Add new product and quantity into the OutOfStockProduct list.
   *
   * @param item -- Item
   */
  public void addOutOfStockProdcut(Item item) {
    this.outOfStockProduct.add(item);
  }

  /**
   * Add new product and quantity into the RemovedProduct list.
   *
   * @param item -- Item
   */
  public void addRemovedProduct(Item item) {
    this.removedProduct.add(item);
  }

  /**
   * Get the total price.
   *
   * @return total price.
   */
  public double getTotalPrice() {
    this.totalPrice = calculatePrice();
    return this.totalPrice;
  }

  /**
   * calcuate the total price.
   *
   * @return total price.
   */
  public double calculatePrice() {
    double price = 0;
    for (Item item : receivedProduct) {
      price += item.getItemPrice();
    }
    return price;
  }

  /**
   * Get the Received Product list.
   *
   * @return the receivedProduct list.
   */
  public List<Item> getReceivedProduct() {
    return this.receivedProduct;
  }

  /**
   * Get the Out Of Stock Product list.
   *
   * @return the outOfStockProduct list.
   */
  public List<Item> getOutOfStockProduct() {
    return this.outOfStockProduct;
  }

  /**
   * Get the Removed Product list.
   *
   * @return the removedProduct list.
   */
  public List<Item> getRemovedProduct() {
    return this.removedProduct;
  }
}