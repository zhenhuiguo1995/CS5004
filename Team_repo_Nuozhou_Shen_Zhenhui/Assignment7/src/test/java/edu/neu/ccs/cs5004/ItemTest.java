package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

  private Beer testBeer;
  private int testQuantity;
  private ShoppingCartItem testItem;

  @Before
  public void setUp() throws Exception {
    testBeer = new Beer("Redwood", "Redwood Hill Beer", 3.2, 21, 2.2);
    testQuantity = 3;
    testItem = new ShoppingCartItem(testBeer, testQuantity);
  }

  @Test
  public void getProduct() {
    assertEquals(testBeer, this.testItem.getProduct());
  }

  @Test
  public void getQuantity() {
    assertEquals(3, this.testItem.getQuantity());
  }

  @Test
  public void setQuantity() {
    this.testItem.setQuantity(testItem.getQuantity() + 2);
    assertEquals(5, this.testItem.getQuantity());
  }


  @Test
  public void setProduct() throws Exception {
    Cheese testCheese = new Cheese("Whole foods", "everyday saving",
        8.0, 6, 2.0);
    this.testItem.setProduct(testCheese);
    assertEquals(testCheese, this.testItem.getProduct());
  }

  @Test
  public void getItemPrice() {
    assertEquals(9.6, this.testItem.getItemPrice(), 2);
  }


}