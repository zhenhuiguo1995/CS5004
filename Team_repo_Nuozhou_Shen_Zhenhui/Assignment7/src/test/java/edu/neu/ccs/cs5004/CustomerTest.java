package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

  private static final String BEER = "Beer";
  private static final String CHEESE = "Cheese";
  private Name name;
  private int age;
  private ShoppingCart testShoppingCart;
  private Customer testCustomer;
  private List<Item> testList;
  private Beer testBeer;
  private int testQuantity;
  private Cheese testCheese;
  private int testQuantity2;
  private ShoppingCartItem testItem;
  private ShoppingCartItem testItem2;
  private Inventory inventory;
  private Map<String, List<Item>> groceryStock;
  private Map<String, List<Item>> householdStock;
  private StockItem stockItem1;
  private StockItem stockItem2;
  private ArrayList<Item> cheeseList;
  private ArrayList<Item> beerList;


  @Before
  public void setUp() throws Exception {
    name = new Name("Alice", "Green");
    age = 18;
    testList = new ArrayList<>();
    testBeer = new Beer("Redwood", "Redwood Hill Beer", 3.2, 21, 2.2);
    testQuantity = 3;
    testCheese = new Cheese("Wholefoods", "Wholefoods cheese", 5.89, 0, 3.0);
    testQuantity2 = 2;
    stockItem1 = new StockItem(testBeer, 4);
    stockItem2 = new StockItem(testCheese, 2);
    beerList = new ArrayList<>();
    beerList.add(stockItem1);
    cheeseList = new ArrayList<>();
    cheeseList.add(stockItem2);
    groceryStock = new HashMap<>();
    groceryStock.put(BEER, beerList);
    groceryStock.put(CHEESE, cheeseList);
    householdStock = new HashMap<>();
    inventory = new Inventory(groceryStock, householdStock);
    testItem = new ShoppingCartItem(testBeer, testQuantity);
    testItem2 = new ShoppingCartItem(testCheese, testQuantity2);
    testList.add(testItem);
    testShoppingCart = new ShoppingCart(testList);
    testCustomer = new Customer(name, age, testShoppingCart);
  }

  @Test
  public void getName() {
    assertEquals("Alice", this.testCustomer.getName().getFirstName());
    assertEquals("Green", this.testCustomer.getName().getLastName());
  }

  @Test
  public void getAge() {
    assertEquals(18, this.testCustomer.getAge());
  }

  @Test
  public void getShoppingCart() {
    List<ShoppingCartItem> list = new ArrayList<>();
    list.add(testItem);
    assertEquals(list, this.testCustomer.getShoppingCart().getShoppingList());
  }

  @Test
  public void addItem() {
    this.testCustomer.addItem(testCheese, inventory);
    assertEquals(1, this.testCustomer.getShoppingCart().getShoppingList().get(1).getQuantity());
    assertEquals(testCheese,
        this.testCustomer.getShoppingCart().getShoppingList().get(1).getProduct());
  }

  @Test
  public void addItem1() {
    this.testCustomer.addItem(testCheese, 2, inventory);
    assertEquals(2, this.testCustomer.getShoppingCart().getShoppingList().get(1).getQuantity());
    assertEquals(testCheese,
        this.testCustomer.getShoppingCart().getShoppingList().get(1).getProduct());
  }

  @Test
  public void testIsOldEnoughToBuy() {
    assertFalse(testCustomer.isOldEnoughToBuy(testItem));
    assertTrue(testCustomer.isOldEnoughToBuy(testItem2));
  }
}