package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a Paper towels.
 */
public class PaperTowels extends AbstractHousehold{

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
    super(manufacturer, productName, price, minimumAge, units);
  }
}
