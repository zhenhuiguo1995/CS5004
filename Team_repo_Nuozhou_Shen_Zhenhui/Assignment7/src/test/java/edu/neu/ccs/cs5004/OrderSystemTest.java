package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OrderSystemTest {

  private OrderSystem testOrderSystem;
  private ShoppingCart testShoppingCart;
  private Inventory testInventory;
  private Customer testCustomer;
  private Customer testCustomer2;
  private Receipt testReceipt;
  private List<Item> testShoppingList = new LinkedList<>();
  private Item testShoppingCartItemBeer1;
  private Item testShoppingCartItemShampoo1;
  private AbstractProduct testBeer1 = new Beer("Beer_Manufacturer_1", "Beer1", 4.5, 21, 20);
  private AbstractProduct testShampoo1 = new Shampoo("Shampoo_Manufacturer_1", "Shampoo1", 15, 3,
      2);
  //  private AbstractProduct testShampoo2 = new Shampoo("Shampoo_Manufacturer_2", "Shampoo2", 12, 3, 4);
  private HashMap<String, List<Item>> testGroceryStock;
  private HashMap<String, List<Item>> testHouseholdStock;
  private Item testStockItemBeer1;
  private Item testStockItemBeer2;
  private Item testStockItemBeer3;
  private Item testStockItemShampoo1;
  //  private Item testStockItemShampoo2;
  private List<Item> testBeerList;
  private List<Item> testShampooList;
  private Item testReceiptItem1;
  private Item testReceiptItem2;
  private List<Item> testRemovedItem;
  private List<Item> testReceivedItem;
  private List<Item> testOutOfStockItem;


  @Before
  public void setUp() {
    //build Inventory
    testStockItemBeer1 = new StockItem(testBeer1, 6);
    testStockItemShampoo1 = new StockItem(testShampoo1, 5);
//    testStockItemShampoo2 = new StockItem(testShampoo2, 5);
    testBeerList = new LinkedList<>();
    testBeerList.add(testStockItemBeer1);
    testGroceryStock = new HashMap<>();
    testGroceryStock.put("Beer", testBeerList);
    testShampooList = new LinkedList<>();
    testShampooList.add(testStockItemShampoo1);
    testHouseholdStock = new HashMap<>();
    testHouseholdStock.put("Shampoo", testShampooList);
    testInventory = new Inventory(testGroceryStock, testHouseholdStock);
    //build OrderSystem
    testOrderSystem = new OrderSystem(testInventory);
    //build ShoppingCart
    testShoppingCartItemBeer1 = new ShoppingCartItem(testBeer1, 3);
    testShoppingCartItemShampoo1 = new ShoppingCartItem(testShampoo1, 2);
    testShoppingList.add(testShoppingCartItemBeer1);
    testShoppingList.add(testShoppingCartItemShampoo1);
    testShoppingCart = new ShoppingCart(testShoppingList);
    //build Customer
    testCustomer = new Customer(new Name("Harry", "Potter"), 25, testShoppingCart);
    testCustomer2 = new Customer(new Name("Harry", "Potter"), 18, testShoppingCart);
    //build receipt
    testReceiptItem1 = new ReceiptItem(testBeer1, 3);
    testReceiptItem2 = new ReceiptItem(testShampoo1, 2);
    testRemovedItem = new LinkedList<>();
    testOutOfStockItem = new LinkedList<>();
    testReceivedItem = new LinkedList<>();
    testReceivedItem.add(testReceiptItem1);
    testReceivedItem.add(testReceiptItem2);
    testReceipt = new Receipt(testReceivedItem, testOutOfStockItem, testRemovedItem);
  }

  @Test
  public void testProcess_noItemRemoved() {
    Receipt actualReceipt = testOrderSystem.process(testCustomer);
    assertEquals(testReceipt.getTotalPrice(), actualReceipt.getTotalPrice(), 2);
    assertEquals(testReceipt.getOutOfStockProduct(), actualReceipt.getOutOfStockProduct());
    assertEquals(testReceipt.getRemovedProduct(), actualReceipt.getRemovedProduct());
    assertEquals(testReceipt.getReceivedProduct(), actualReceipt.getReceivedProduct());
  }

  @Test
  public void testProcess_ItemRemoved() {
    testReceivedItem.remove(testReceiptItem1);
    testRemovedItem.add(testReceiptItem1);
    testReceipt = new Receipt(testReceivedItem, testOutOfStockItem, testRemovedItem);
    Receipt actualReceipt = testOrderSystem.process(testCustomer2);
    assertEquals(testReceipt.getTotalPrice(), actualReceipt.getTotalPrice(), 2);
    assertEquals(testReceipt.getOutOfStockProduct(), actualReceipt.getOutOfStockProduct());
    assertEquals(testReceipt.getRemovedProduct(), actualReceipt.getRemovedProduct());
    assertTrue(testReceipt.getReceivedProduct().equals(actualReceipt.getReceivedProduct()));
  }


}