package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

  private ShoppingCart testShoppingCart;
  private List<Item> shoppingList;
  private double totalPrice;
  private static final String BEER = "Beer";
  private static final String CHEESE = "Cheese";
  private static final String SALMON = "Salmon";
  private static final String SHAMPOO = "Shampoo";
  private static final String PAPER_TOWELS = "PaperTowels";
  private Beer testBeer;
  private int testQuantity1;
  private Item testItem1;
  private Cheese testCheese;
  private int testQuantity2;
  private Item testItem2;
  private Salmon testSalmon;
  private int testQuantity3;
  private Item testItem3;
  private Shampoo testShampoo;
  private int testQuantity4;
  private Item testItem4;
  private PaperTowels testPaperTowels;
  private int testQuantity5;
  private Item testItem5;
  private List<Item> list;
  private Inventory inventory;
  private HashMap<String, List<Item>> groceryStock;
  private HashMap<String, List<Item>> householdStock;
  private Item stockItem1;
  private Item stockItem2;
  private Item stockItem3;
  private Item stockItem4;
  private Item stockItem5;
  private Beer testBeer2;
  private Item stockItem6;
  private List<Item> cheeseList;
  private List<Item> beerList;
  private List<Item> salmonList;
  private List<Item> paperTowelsList;
  private List<Item> shampooList;
  private FulfillOrderResult testFulfillOrderResult;


  @Before
  public void setUp() throws Exception {
    testBeer = new Beer("Redwood", "Redwood Hill Beer", 3.2, 21, 2.2);
    testQuantity1 = 3;
    testItem1 = new ShoppingCartItem(testBeer, testQuantity1);
    testCheese = new Cheese("Wholefoods", "Wholefoods cheese", 5.89, 0, 3.0);
    testQuantity2 = 2;
    testItem2 = new ShoppingCartItem(testCheese, testQuantity2);
    testSalmon = new Salmon("Wholefoods", "Wholefoods Salmon", 7.99, 0, 2.0);
    testQuantity3 = 4;
    testItem3 = new ShoppingCartItem(testSalmon, testQuantity3);
    testShampoo = new Shampoo("Kirkland", "Kirkland Shampoo", 4.5, 0, 1);
    testQuantity4 = 1;
    testItem4 = new ShoppingCartItem(testShampoo, testQuantity4);
    testPaperTowels = new PaperTowels("Kirkland", "Kirkland papertowel", 12.0, 0, 12);
    testQuantity5 = 1;
    testItem5 = new ShoppingCartItem(testPaperTowels, testQuantity5);
    shoppingList = new ArrayList<Item>();
    testShoppingCart = new ShoppingCart(new ArrayList<Item>());
    list = new ArrayList<>();
    stockItem1 = new StockItem(testBeer, 4);
    stockItem2 = new StockItem(testCheese, 1);
    stockItem3 = new StockItem(testSalmon, 4);
    stockItem4 = new StockItem(testShampoo, 10);
    stockItem5 = new StockItem(testPaperTowels, 2);
    testBeer2 = new Beer("Kirkland", "Kirkland Beer", 2.0, 21, 2.2);
    stockItem6 = new StockItem(testBeer2, 5);
    beerList = new ArrayList<>();
    beerList.add(stockItem6);
    beerList.add(stockItem1);
    cheeseList = new ArrayList<>();
    cheeseList.add(stockItem2);
    salmonList = new ArrayList<>();
    salmonList.add(stockItem3);
    paperTowelsList = new ArrayList<>();
    paperTowelsList.add(stockItem5);
    shampooList = new ArrayList<>();
    shampooList.add(stockItem4);
    groceryStock = new HashMap<>();
    groceryStock.put(BEER, beerList);
    groceryStock.put(CHEESE, cheeseList);
    groceryStock.put(SALMON, salmonList);
    householdStock = new HashMap<>();
    householdStock.put(PAPER_TOWELS, paperTowelsList);
    householdStock.put(SHAMPOO, shampooList);
    inventory = new Inventory(groceryStock, householdStock);
    testFulfillOrderResult = new FulfillOrderResult();
  }

  @Test
  public void calculateTotalPrice() {
    assertEquals(0, this.testShoppingCart.calculateTotalPrice(), 2);
    this.testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    assertEquals(9.6, this.testShoppingCart.calculateTotalPrice(), 2);
  }

  @Test
  public void getTotalPrice() {
    assertEquals(0, this.testShoppingCart.getTotalPrice(), 2);
    this.testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    assertEquals(9.6, this.testShoppingCart.getTotalPrice(), 2);
  }

  @Test
  public void getShoppingList() {
    this.testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    assertEquals(testBeer, this.testShoppingCart.getShoppingList().get(0).getProduct());
    assertEquals(testQuantity1, this.testShoppingCart.getShoppingList().get(0).getQuantity());
  }

  @Test
  public void addShoppingCartItem() {
    this.testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    assertEquals(testBeer, this.testShoppingCart.getShoppingList().get(0).getProduct());
    assertEquals(testQuantity1, this.testShoppingCart.getShoppingList().get(0).getQuantity());
    try {
      this.testShoppingCart.addShoppingCartItem(testCheese, testQuantity2, inventory);
      fail("An exception should have been thrown");
    } catch (IllegalArgumentException e) {

    }

    this.testShoppingCart.addShoppingCartItem(testSalmon, testQuantity3, inventory);
    assertEquals(testSalmon, this.testShoppingCart.getShoppingList().get(1).getProduct());
    assertEquals(testQuantity3, this.testShoppingCart.getShoppingList().get(1).getQuantity());
    this.testShoppingCart.addShoppingCartItem(testShampoo, testQuantity4, inventory);
    assertEquals(testShampoo, this.testShoppingCart.getShoppingList().get(2).getProduct());
    assertEquals(testQuantity4, this.testShoppingCart.getShoppingList().get(2).getQuantity());
    this.testShoppingCart.addShoppingCartItem(testPaperTowels, testQuantity5, inventory);
    assertEquals(testPaperTowels, this.testShoppingCart.getShoppingList().get(3).getProduct());
    assertEquals(testQuantity5, this.testShoppingCart.getShoppingList().get(3).getQuantity());
  }


  @Test
  public void throwAnException() {
    try {
      this.testShoppingCart.addShoppingCartItem(testCheese, 10, inventory);
      fail("An exception should have been thrown");
    } catch (IllegalArgumentException e) {

    }
  }

  @Test
  public void testFulfillOrder_noItemRemoved() {
    testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    testShoppingCart.addShoppingCartItem(testSalmon, testQuantity3, inventory);
    FulfillOrderResult actualFulFillOrderResult = testShoppingCart.fulfillOrder(inventory);
    assertEquals(testFulfillOrderResult.getOutOfStockProducts(),
        actualFulFillOrderResult.getOutOfStockProducts());
    assertEquals(testFulfillOrderResult.getRemovedProducts(),
        actualFulFillOrderResult.getRemovedProducts());
  }

  @Test
  public void testFulfillOrder_itemRemoved_substitute() {
    testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    testShoppingCart.addShoppingCartItem(testSalmon, testQuantity3, inventory);
    inventory.updateStock(testItem1);
    FulfillOrderResult actualFulFillOrderResult = testShoppingCart.fulfillOrder(inventory);
    Item testReceiptItem = new ReceiptItem(testBeer, testQuantity1);
    testFulfillOrderResult.addOutOfStockProduct(testReceiptItem);
    assertEquals(testFulfillOrderResult.getRemovedProducts(),
        actualFulFillOrderResult.getRemovedProducts());
    assertEquals(testFulfillOrderResult.getOutOfStockProducts(),
        actualFulFillOrderResult.getOutOfStockProducts());
  }

  @Test
  public void testFulfillOrder_itemRemoved_noSubstitute() {
    testShoppingCart.addShoppingCartItem(testBeer, testQuantity1, inventory);
    testShoppingCart.addShoppingCartItem(testSalmon, testQuantity3, inventory);
    inventory.updateStock(testItem3);
    FulfillOrderResult actualFulFillOrderResult = testShoppingCart.fulfillOrder(inventory);
    Item testReceiptItem = new ReceiptItem(testSalmon, testQuantity3);
    testFulfillOrderResult.addOutOfStockProduct(testReceiptItem);
    testFulfillOrderResult.addRemovedProduct(testReceiptItem);
    assertEquals(testFulfillOrderResult.getRemovedProducts(),
        actualFulFillOrderResult.getRemovedProducts());
    assertEquals(testFulfillOrderResult.getOutOfStockProducts(),
        actualFulFillOrderResult.getOutOfStockProducts());
  }

}