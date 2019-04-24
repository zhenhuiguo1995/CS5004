package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a Salmon.
 */
public class Salmon extends AbstractGrocery{

  /**
   * Instantiates a new Abstract grocery.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param weight the weight
   */
  public Salmon(String manufacturer, String productName, double price, int minimumAge,
      double weight) {
    super(manufacturer, productName, price, minimumAge, weight);
  }
}
