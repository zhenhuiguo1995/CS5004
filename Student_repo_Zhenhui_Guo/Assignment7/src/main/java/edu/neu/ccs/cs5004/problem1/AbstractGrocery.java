package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a grocery type.
 */
public abstract class AbstractGrocery extends AbstractProduct {
  private double weight;

  /**
   * Instantiates a new Abstract grocery.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param weight the weight
   */
  public AbstractGrocery(String manufacturer, String productName, double price,
      int minimumAge, double weight) {
    super(manufacturer, productName, price, minimumAge);
    this.weight = weight;
  }

  /**
   * Gets weight.
   *
   * @return the weight
   */
  public double getWeight() {
    return weight;
  }
}
