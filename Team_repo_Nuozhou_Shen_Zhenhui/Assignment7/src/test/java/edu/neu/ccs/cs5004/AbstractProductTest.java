package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractProductTest {

  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;
  private double weight;
  private AbstractProduct product;

  @Before
  public void setUp() throws Exception {
    this.manufacturer = "Whole foods";
    this.productName = "Royal cheese";
    this.price = 2.0;
    this.minimumAge = 10;
    this.weight = 19.8;
    this.product = new Cheese(this.manufacturer, this.productName, this.price,
        this.minimumAge, this.weight);
  }

  @Test
  public void getProductType() throws Exception {
    assertEquals("Cheese", this.product.getProductType());
  }

  @Test
  public void getManufacturer() throws Exception {
    assertEquals(this.manufacturer, this.product.getManufacturer());
  }

  @Test
  public void getProductName() throws Exception {
    assertEquals(this.productName, this.product.getProductName());
  }

  @Test
  public void getPrice() throws Exception {
    assertEquals(this.price, this.product.getPrice(), 0.001);
  }

  @Test
  public void getMinimumAge() throws Exception {
    assertEquals(this.minimumAge, this.product.getMinimumAge());
  }

  @Test
  public void setPrice() throws Exception {
    double newPrice = 3.0;
    this.product.setPrice(newPrice);
    assertEquals(newPrice, this.product.getPrice(), 0.001);
  }
}