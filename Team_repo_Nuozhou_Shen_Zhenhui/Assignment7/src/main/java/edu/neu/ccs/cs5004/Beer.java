package edu.neu.ccs.cs5004;

/**
 * Represents details of a beer.
 */
public class Beer extends AbstractGrocery {

  private static final String PRODUCT_TYPE = "Beer";

  /**
   * Instantiates a new Abstract grocery.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param weight the weight
   */
  public Beer(String manufacturer, String productName, double price, int minimumAge,
      double weight) {
    super(PRODUCT_TYPE, manufacturer, productName, price, minimumAge, weight);
  }
}
