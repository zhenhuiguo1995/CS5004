package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractGroceryTest {

  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;
  private double weight;
  private AbstractGrocery grocery;

  @Before
  public void setUp() throws Exception {
    this.manufacturer = "Whole foods";
    this.productName = "North Arctic Salmon";
    this.price = 18.8;
    this.minimumAge = 5;
    this.weight = 1.0;
    this.grocery = new Salmon(this.manufacturer, this.productName, this.price,
        this.minimumAge, this.weight);
  }

  @Test
  public void getWeight() throws Exception {
    assertEquals(this.weight, this.grocery.getWeight(), 0.001);
  }

}