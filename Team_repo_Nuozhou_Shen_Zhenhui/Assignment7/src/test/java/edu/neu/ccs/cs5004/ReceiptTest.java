package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {

  private Receipt testReceipt;
  private double totalPrice;
  private ArrayList<Item> receivedProduct;
  private ArrayList<Item> outOfStockProduct;
  private ArrayList<Item> removedProduct;
  private Beer testBeer;
  private int testQuantity1;
  private ReceiptItem testItem1;
  private Cheese testCheese;
  private int testQuantity2;
  private ReceiptItem testItem2;
  private Salmon testSalmon;
  private int testQuantity3;
  private ReceiptItem testItem3;
  private List<Item> list;


  @Before
  public void setUp() throws Exception {
    testBeer = new Beer("Redwood", "Redwood Hill Beer", 3.2, 21, 2.2);
    testQuantity1 = 3;
    testItem1 = new ReceiptItem(testBeer, testQuantity1);
    testCheese = new Cheese("Wholefoods", "Wholefoods cheese", 5.89, 0, 3.0);
    testQuantity2 = 2;
    testItem2 = new ReceiptItem(testCheese, testQuantity2);
    testSalmon = new Salmon("Wholefoods", "Wholefoods Salmon", 7.99, 0, 2.0);
    testQuantity2 = 4;
    testItem3 = new ReceiptItem(testSalmon, testQuantity3);
    receivedProduct = new ArrayList<>();
    outOfStockProduct = new ArrayList<>();
    removedProduct = new ArrayList<>();
    testReceipt = new Receipt(receivedProduct, outOfStockProduct, removedProduct);
    list = new ArrayList<Item>();


  }

  @Test
  public void addReceivedProduct() {
    this.testReceipt.addReceivedProduct(testItem1);
    list.add(testItem1);
    assertEquals(list, this.testReceipt.getReceivedProduct());
  }

  @Test
  public void addOutOfStockProdcut() {
    this.testReceipt.addOutOfStockProdcut(testItem2);
    list.add(testItem2);
    assertEquals(list, this.testReceipt.getOutOfStockProduct());

  }

  @Test
  public void addRemovedProduct() {
    this.testReceipt.addRemovedProduct(testItem3);
    list.add(testItem3);
    assertEquals(list, this.testReceipt.getRemovedProduct());
  }

  @Test
  public void getTotalPrice() {
    assertEquals(0, this.testReceipt.getTotalPrice(), 2);
    this.testReceipt.addReceivedProduct(testItem1);
    assertEquals(9.6, this.testReceipt.getTotalPrice(), 2);
    this.testReceipt.addOutOfStockProdcut(testItem2);
    assertEquals(9.6, this.testReceipt.getTotalPrice(), 2);
    this.testReceipt.addRemovedProduct(testItem3);
    assertEquals(9.6, this.testReceipt.getTotalPrice(), 2);


  }

  @Test
  public void calculatePrice() {
    assertEquals(0, this.testReceipt.calculatePrice(), 2);
    this.testReceipt.addReceivedProduct(testItem1);
    assertEquals(9.6, this.testReceipt.calculatePrice(), 2);
    this.testReceipt.addOutOfStockProdcut(testItem2);
    assertEquals(9.6, this.testReceipt.calculatePrice(), 2);
    this.testReceipt.addRemovedProduct(testItem3);
    assertEquals(9.6, this.testReceipt.calculatePrice(), 2);

  }

  @Test
  public void getReceivedProduct() {
    this.testReceipt.addReceivedProduct(testItem1);
    list.add(testItem1);
    assertEquals(list, this.testReceipt.getReceivedProduct());
  }

  @Test
  public void getOutOfStockProduct() {
    this.testReceipt.addOutOfStockProdcut(testItem2);
    list.add(testItem2);
    assertEquals(list, this.testReceipt.getOutOfStockProduct());
  }

  @Test
  public void getRemovedProduct() {
    this.testReceipt.addRemovedProduct(testItem3);
    list.add(testItem3);
    assertEquals(list, this.testReceipt.getRemovedProduct());
  }
}