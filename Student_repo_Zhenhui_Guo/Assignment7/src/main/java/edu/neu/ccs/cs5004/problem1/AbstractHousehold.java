package edu.neu.ccs.cs5004.problem1;

/**
 * Represent details of the Abstract household class.
 */
public class AbstractHousehold extends AbstractProduct {
  private int units;

  /**
   * Instantiates a new Abstract product.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param units the units
   */
  public AbstractHousehold(String manufacturer, String productName, double price,
      int minimumAge, int units) {
    super(manufacturer, productName, price, minimumAge);
    this.units = units;
  }

  /**
   * Gets units.
   *
   * @return the units
   */
  public int getUnits() {
    return units;
  }
}
