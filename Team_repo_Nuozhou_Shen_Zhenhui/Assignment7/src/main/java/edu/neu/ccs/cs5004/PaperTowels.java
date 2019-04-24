package edu.neu.ccs.cs5004;

/**
 * Represents details of a Paper towels.
 */
public class PaperTowels extends AbstractHousehold {

  private static final String PRODUCT_TYPE = "PaperTowels";

  /**
   * Instantiates a new Abstract product.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param units the units
   */
  public PaperTowels(String manufacturer, String productName, double price, int minimumAge,
      int units) {
    super(PRODUCT_TYPE, manufacturer, productName, price, minimumAge, units);
  }
}
