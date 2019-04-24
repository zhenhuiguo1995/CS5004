package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a Shampoo.
 */
public class Shampoo extends AbstractHousehold {

  /**
   * Instantiates a new Abstract product.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param units the units
   */
  public Shampoo(String manufacturer, String productName, double price, int minimumAge,
      int units) {
    super(manufacturer, productName, price, minimumAge, units);
  }
}
