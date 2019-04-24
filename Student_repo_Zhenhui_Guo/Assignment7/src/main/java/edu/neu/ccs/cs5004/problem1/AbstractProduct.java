package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of an abstract product, including manufacturer, product name,
 * price and minimum age to buy the product.
 */
public abstract class AbstractProduct {
  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;

  /**
   * Instantiates a new Abstract product.
   *
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   */
  public AbstractProduct(String manufacturer, String productName, double price, int minimumAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = minimumAge;
  }

  /**
   * Gets manufacturer.
   *
   * @return the manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Gets product name.
   *
   * @return the product name
   */
  public String getProductName() {
    return productName;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Gets minimum age.
   *
   * @return the minimum age
   */
  public int getMinimumAge() {
    return minimumAge;
  }
}
