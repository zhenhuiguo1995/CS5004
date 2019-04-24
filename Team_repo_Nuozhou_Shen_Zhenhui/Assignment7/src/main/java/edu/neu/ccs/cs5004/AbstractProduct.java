package edu.neu.ccs.cs5004;

/**
 * Represents details of an abstract product, including manufacturer, product name, price and
 * minimum age to buy the product.
 */
public abstract class AbstractProduct {

  private String productType;
  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;

  /**
   * Instantiates a new Abstract product.
   *
   * @param productType the product type
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   */
  public AbstractProduct(String productType, String manufacturer, String productName, double price,
      int minimumAge) {
    this.productType = productType;
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = minimumAge;
  }

  /**
   * Get the product type.
   *
   * @return the product type as String
   */
  public String getProductType() {
    return productType;
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


  /**
   * Set the price.
   * @param price the new price
   */
  public void setPrice(double price) {
    this.price = price;
  }

//  @Override
//  public boolean equals(Object obj) {
//    if(obj.getClass().equals(this.getClass())){
//      obj = (AbstractProduct)obj;
//      return ((AbstractProduct) obj).getPrice() == this.getPrice()
//          && ((AbstractProduct) obj).getProductType().equals(this.getProductType());
//    }
//
//  }
}
