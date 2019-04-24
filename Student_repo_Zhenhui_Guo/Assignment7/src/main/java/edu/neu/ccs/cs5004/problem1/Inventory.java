package edu.neu.ccs.cs5004.problem1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents details of a inventory.
 */
public class Inventory {
  private HashMap<String, ArrayList<StockItem>> groceryStock;
  private HashMap<String, ArrayList<StockItem>> householdStock;
  private static final String BEER = "Beer";
  private static final String CHEESE = "Cheese";
  private static final String SALMON = "Salmon";
  private static final String SHAMPOO = "Shampoo";
  private static final String PAPER_TOWELS = "PaperTowels";

  /**
   * Instantiates a new Inventory.
   *
   * @param groceryStock the grocery stock
   * @param householdStock the household stock
   */
  public Inventory(
      HashMap<String, ArrayList<StockItem>> groceryStock,
      HashMap<String, ArrayList<StockItem>> householdStock) {
    this.groceryStock = groceryStock;
    this.householdStock = householdStock;
  }

  /**
   * Add new stock item boolean.
   *
   * @param stockItem the stock item
   * @return the boolean
   */
  public boolean addNewStockItem(StockItem stockItem) {
    if (stockItem.getProduct() instanceof AbstractGrocery) {
      if (stockItem.getProduct() instanceof Beer) {
        groceryStock.get(BEER).add(stockItem);
      } else if (stockItem.getProduct() instanceof Salmon) {
        groceryStock.get(SALMON).add(stockItem);
      } else {
        groceryStock.get(CHEESE).add(stockItem);
      }
      return true;
    } else if (stockItem.getProduct() instanceof AbstractHousehold){
      if (stockItem.getProduct() instanceof Shampoo) {
        householdStock.get(SHAMPOO).add(stockItem);
      } else {
        householdStock.get(PAPER_TOWELS).add(stockItem);
      }
      return true;
    } else {
      return false;
    }
   }

  /**
   * Gets retail value.
   *
   * @return the retail value
   */
  public double getRetailValue() {
    double total = 0;
    for (String key : groceryStock.keySet()) {
      for (StockItem stockItem : groceryStock.get(key)) {
        total += stockItem.getQuantity() * stockItem.getProduct().getPrice();
      }
    }

    for (String key : householdStock.keySet()) {
      for (StockItem stockItem : householdStock.get(key)) {
        total += stockItem.getQuantity() * stockItem.getProduct().getPrice();
      }
    }

    return total;
  }

  /**
   * Gets grocery stock.
   *
   * @return the grocery stock
   */
  public HashMap<String, ArrayList<StockItem>> getGroceryStock() {
    return groceryStock;
  }

  /**
   * Gets household stock.
   *
   * @return the household stock
   */
  public HashMap<String, ArrayList<StockItem>> getHouseholdStock() {
    return householdStock;
  }
}
