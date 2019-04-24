package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a cheese class.
 */
public class Cheese extends AbstractGrocery {

  /**
   * Instantiates a new Abstract grocery.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param weight the weight
   */
  public Cheese(String manufacturer, String productName, double price, int minimumAge,
      double weight) {
    super(manufacturer, productName, price, minimumAge, weight);
  }
}
