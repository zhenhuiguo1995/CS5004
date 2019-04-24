package edu.neu.ccs.cs5004;

/**
 * Represents details of a shopping item.
 */
public class ShoppingCartItem extends Item {

  /**
   * Instantiates a new shopping cart item.
   *
   * @param product -- product to be added into the shopping cart.
   * @param quantity -- quantity to be added into the shopping cart.
   */
  public ShoppingCartItem(AbstractProduct product, int quantity) {
    super(product, quantity);
  }

}
