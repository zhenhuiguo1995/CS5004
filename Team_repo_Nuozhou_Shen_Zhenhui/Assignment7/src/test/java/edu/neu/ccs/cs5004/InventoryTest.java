package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

  // initialize constants
  private static final String BEER = "Beer";
  private static final String CHEESE = "Cheese";
  private static final String SALMON = "Salmon";
  private static final String SHAMPOO = "Shampoo";
  private static final String PAPER_TOWELS = "PaperTowels";

  private Inventory testInventory;
  private ShoppingCartItem testShoppingCartItemBeer1;
  private ShoppingCartItem testShoppingCartItemShampoo1;
  private AbstractProduct testBeer1 = new Beer("Beer_Manufacturer_1",
      "Beer1", 4.5, 21, 20);
  private AbstractProduct testBeer2 = new Beer("Beer_Manufacturer_2",
      "Beer2", 5, 21, 22);
  private AbstractProduct testBeer3 = new Beer("Beer_Manufacturer_3",
      "Beer3", 3, 21, 15);
  private AbstractProduct testShampoo1 = new Shampoo("Shampoo_Manufacturer_1",
      "Shampoo1", 15, 3, 2);
  private AbstractProduct testShampoo2 = new Shampoo("Shampoo_Manufacturer_2",
      "Shampoo2", 12, 3, 4);
  private HashMap<String, List<Item>> testGroceryStock;
  private HashMap<String, List<Item>> testHouseholdStock;
  private StockItem testStockItemBeer1;
  private StockItem testStockItemBeer2;
  private StockItem testStockItemBeer3;
  private StockItem testStockItemShampoo1;
  private StockItem testStockItemShampoo2;
  private List<Item> testBeerList;
  private List<Item> testShampooList;

  @Before
  public void setUp() throws Exception {
    testShoppingCartItemBeer1 = new ShoppingCartItem(testBeer1, 5);
    testShoppingCartItemShampoo1 = new ShoppingCartItem(testShampoo1, 2);
    testStockItemBeer1 = new StockItem(testBeer1, 6);
    testStockItemBeer2 = new StockItem(testBeer2, 6);
    testStockItemBeer3 = new StockItem(testBeer3, 10);
    testStockItemShampoo1 = new StockItem(testShampoo1, 5);
    testStockItemShampoo2 = new StockItem(testShampoo2, 5);
    testBeerList = new LinkedList<>();
    testBeerList.add(testStockItemBeer1);
    testBeerList.add(testStockItemBeer2);
    testBeerList.add(testStockItemBeer3);
    testShampooList = new LinkedList<>();
    testShampooList.add(testStockItemShampoo1);
    testShampooList.add(testStockItemShampoo2);
    // initialize the grocery stock hashmap
    testGroceryStock = new HashMap<>();
    testGroceryStock.put(BEER, new LinkedList<>());
    testGroceryStock.put(SALMON, new LinkedList<>());
    testGroceryStock.put(CHEESE, new LinkedList<>());
    testGroceryStock.get(BEER).add(testStockItemBeer1);
    testGroceryStock.get(BEER).add(testStockItemBeer2);
    testGroceryStock.get(BEER).add(testStockItemBeer3);
    testHouseholdStock = new HashMap<>();
    // initialize the household stock hashmap
    testHouseholdStock = new HashMap<>();
    testHouseholdStock.put(SHAMPOO, new LinkedList<>());
    testHouseholdStock.put(PAPER_TOWELS, new LinkedList<>());
    testHouseholdStock.get(SHAMPOO).add(testStockItemShampoo1);
    testHouseholdStock.get(SHAMPOO).add(testStockItemShampoo2);
    testInventory = new Inventory(testGroceryStock, testHouseholdStock);
  }

  @Test
  public void addNewBeer() throws Exception {
    StockItem stockItem = new StockItem(new Beer("Beer manufacturer",
        "RedWine", 188.88, 21, 3.0), 5);
    assertTrue(this.testInventory.addNewStockItem(stockItem));
  }

  @Test
  public void addNewCheese() throws Exception {
    StockItem stockItem = new StockItem(new Cheese("Cheese manufacturer",
        "365 Farm", 18.88, 8, 5), 5);
    assertTrue(this.testInventory.addNewStockItem(stockItem));
  }

  @Test
  public void addNewSalmon() throws Exception {
    StockItem stockItem = new StockItem(new Salmon("Salmon manufacturer",
        "fresh salmon", 18.88, 8, 1), 5);
    assertTrue(this.testInventory.addNewStockItem(stockItem));
  }

  @Test
  public void addNewPaperTowel() throws Exception {
    StockItem stockItem = new StockItem(new PaperTowels("Paper Towel manufacturer",
        "paper towel", 18.88, 8, 12), 5);
    assertTrue(this.testInventory.addNewStockItem(stockItem));
  }

  @Test
  public void addNewShampoo() throws Exception {
    StockItem stockItem = new StockItem(new Shampoo("Clear",
        "HairCleaner", 18.88, 8, 1), 5);
    assertTrue(this.testInventory.addNewStockItem(stockItem));
  }

  @Test
  public void getRetailValue() throws Exception {
    assertEquals(222, this.testInventory.getRetailValue(), 0.001);
  }

  @Test
  public void isInStockGroceryStockItem() throws Exception {
    assertTrue(this.testInventory.isInStock(testStockItemBeer1));
  }

  @Test
  public void isInStockHouseholdStockItem() throws Exception {
    assertTrue(this.testInventory.isInStock(testStockItemShampoo1));
  }

  @Test
  public void isInStockGroceryShoppingCartItem() throws Exception {
    assertTrue(this.testInventory.isInStock(testShoppingCartItemBeer1));
  }

  @Test
  public void isInStockHouseholdShoppingCartItem() throws Exception {
    assertTrue(this.testInventory.isInStock(testShoppingCartItemShampoo1));
  }

  @Test
  public void notInStockGroceryShoppingCartItem() throws Exception {
    testShoppingCartItemBeer1 = new ShoppingCartItem(testBeer1, 7);
    assertFalse(this.testInventory.isInStock(testShoppingCartItemBeer1));
  }

  @Test
  public void notInStockGroceryItem() throws Exception {
    testShoppingCartItemBeer1 = new ShoppingCartItem(new Beer("manufacturer",
        "RedWine", 188.88, 21, 3.0), 7);
    assertFalse(this.testInventory.isInStock(testShoppingCartItemBeer1));
  }

  @Test
  public void notInStockHouseholdItem() throws Exception {
    ShoppingCartItem item = new ShoppingCartItem(new Shampoo("Shampoo manufactuer",
        "clean hair", 18.88, 8, 1), 7);
    assertFalse(this.testInventory.isInStock(item));
  }


  @Test
  public void notInStockHouseholdShoppingCartItem() throws Exception {
    testShoppingCartItemShampoo1 = new ShoppingCartItem(testShampoo1, 6);
    assertFalse(this.testInventory.isInStock(testShoppingCartItemShampoo1));
  }

  @Test
  public void updateStockHousehold() throws Exception {
    this.testInventory.updateStock(testShoppingCartItemBeer1);
    assertEquals(1, testStockItemBeer1.getQuantity());
  }

  @Test
  public void updateStockGrocery() throws Exception {
    this.testInventory.updateStock(testShoppingCartItemShampoo1);
    assertEquals(3, testStockItemShampoo1.getQuantity());
  }

  @Test
  public void getGroceryStock() throws Exception {
    assertEquals(this.testGroceryStock, this.testInventory.getGroceryStock());
  }

  @Test
  public void getHouseholdStock() throws Exception {
    assertEquals(this.testHouseholdStock, this.testInventory.getHouseholdStock());
  }

}