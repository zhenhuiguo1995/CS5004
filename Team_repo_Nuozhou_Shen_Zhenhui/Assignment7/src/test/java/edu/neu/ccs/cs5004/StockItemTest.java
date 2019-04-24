package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {

  private Shampoo shampoo;
  private int quantity;
  private StockItem stockItem;
  private Item shoppingItem;
  private Shampoo shoppingShampoo;

  @Before
  public void setUp() throws Exception {
    this.shampoo = new Shampoo("Beauty", "HairCare", 10.99,
        12, 1);
    this.quantity = 5;
    this.stockItem = new StockItem(this.shampoo, this.quantity);
  }

  @Test
  public void checkItem() throws Exception {
    assertTrue(this.stockItem.checkItem(3));
  }

  @Test
  public void quantityNotEnough() throws Exception {
    assertFalse(this.stockItem.checkItem(6));
  }

  @Test
  public void isQualifiedToSubstitute() throws Exception {
    this.shoppingShampoo = new Shampoo("Alexa", "ClearHair", 11.00,
        12, 1);
    this.shoppingItem = new ShoppingCartItem(this.shoppingShampoo, this.quantity);
    assertTrue(this.stockItem.isQualifiedToSubstitute(this.shoppingItem));
  }

  @Test
  public void quantityNotEnoughToSubstitute() {
    this.shoppingShampoo = new Shampoo("Alexa", "ClearHair", 10.88,
        12, 1);
    this.shoppingItem = new ShoppingCartItem(this.shoppingShampoo, 6);
    assertFalse(this.stockItem.isQualifiedToSubstitute(this.shoppingItem));
  }

  @Test
  public void PriceTooHighToSubstitute() {
    this.shoppingShampoo = new Shampoo("Alexa", "ClearHair", 10.98,
        12, 1);
    this.shoppingItem = new ShoppingCartItem(this.shoppingShampoo, 4);
    assertFalse(this.stockItem.isQualifiedToSubstitute(this.shoppingItem));
  }

  @Test
  public void UnitsNotEnoughToSubstitute() {
    this.shoppingShampoo = new Shampoo("Alexa", "ClearHair", 11.99,
        12, 3);
    this.shoppingItem = new ShoppingCartItem(this.shoppingShampoo, 4);
    assertFalse(this.stockItem.isQualifiedToSubstitute(this.shoppingItem));
  }

  @Test
  public void WeightsNotEnoughToSubstitute() {
    Cheese shoppingCheese = new Cheese("Whole Foods", "Everyday Saving",
        2.88, 6, 1.0);
    this.shoppingItem = new ShoppingCartItem(shoppingCheese, 4);
    Cheese substituteCheese = new Cheese("QFC", "365 Farm", 2.59,
        6, 0.99);
    this.stockItem = new StockItem(substituteCheese, 5);
    assertFalse(this.stockItem.isQualifiedToSubstitute(this.shoppingItem));
  }

  @Test
  public void groceryWeightEnoughToSubstitute() {
    Cheese shoppingCheese = new Cheese("Whole Foods", "Everyday Saving",
        2.88, 6, 1.0);
    this.shoppingItem = new ShoppingCartItem(shoppingCheese, 4);
    Cheese substituteCheese = new Cheese("QFC", "365 Farm", 2.59,
        6, 1.01);
    this.stockItem = new StockItem(substituteCheese, 5);
    assertTrue(this.stockItem.isQualifiedToSubstitute(this.shoppingItem));
  }

}