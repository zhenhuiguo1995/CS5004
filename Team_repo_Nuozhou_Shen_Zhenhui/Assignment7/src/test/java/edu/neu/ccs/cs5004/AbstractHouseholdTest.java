package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractHouseholdTest {

  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;
  private int units;
  private AbstractHousehold household;

  @Before
  public void setUp() throws Exception {
    this.manufacturer = "Whole foods";
    this.productName = "Best housing company";
    this.price = 6.39;
    this.minimumAge = 7;
    this.units = 6;
    this.household = new PaperTowels(this.manufacturer, this.productName, this.price,
        this.minimumAge, this.units);
  }

  @Test
  public void getUnits() throws Exception {
    assertEquals(this.units, this.household.getUnits());
  }

}