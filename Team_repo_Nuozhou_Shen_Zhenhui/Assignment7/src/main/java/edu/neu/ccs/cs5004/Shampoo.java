package edu.neu.ccs.cs5004;

/**
 * Represents details of a Shampoo.
 */
public class Shampoo extends AbstractHousehold {

  private static final String PRODUCT_TYPE = "Shampoo";

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
    super(PRODUCT_TYPE, manufacturer, productName, price, minimumAge, units);
  }
}
