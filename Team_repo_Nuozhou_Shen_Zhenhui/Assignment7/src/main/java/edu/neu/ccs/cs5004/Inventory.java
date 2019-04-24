package edu.neu.ccs.cs5004;

import java.util.List;
import java.util.Map;

/**
 * Represents details of a inventory.
 */
public class Inventory {

  private Map<String, List<Item>> groceryStock;
  private Map<String, List<Item>> householdStock;
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
      Map<String, List<Item>> groceryStock,
      Map<String, List<Item>> householdStock) {
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
    } else if (stockItem.getProduct() instanceof AbstractHousehold) {
      if (stockItem.getProduct() instanceof Shampoo) {
        householdStock.get(SHAMPOO).add(stockItem);
      } else {
        householdStock.get(PAPER_TOWELS).add(stockItem);
      }
      return true;
    } else {
      return false;
    }
    // for now we don't need to consider this situation
  }

  /**
   * Gets retail value.
   *
   * @return the retail value
   */
  public double getRetailValue() {
    double total = 0;
    for (Map.Entry<String, List<Item>> entry : groceryStock.entrySet()) {
      for (Item stockItem : entry.getValue()) {
        total += stockItem.getItemPrice();
      }
    }

    for (Map.Entry<String, List<Item>> entry : householdStock.entrySet()) {
      for (Item stockItem : entry.getValue()) {
        total += stockItem.getItemPrice();
      }
    }

    return total;
  }

  /**
   * Check if the product is in stock.
   *
   * @param item the product in the shopping cart
   * @return true if in stock, false if not
   */
  public boolean isInStock(Item item) {
    List<Item> sameTypeOfProducts = getSameTypeOfProduct(item);
    for (Item stockItem : sameTypeOfProducts) {
      if (item.getProduct().equals(stockItem.getProduct())) {
        return stockItem.getQuantity() >= item.getQuantity();
      }
    }
    return false;
  }

  /**
   * Helper method to get the list of products that are the same type with the products in the
   * shopping cart.
   *
   * @param item the item in the shopping cart
   * @return the list of products in the same type
   */
  public List<Item> getSameTypeOfProduct(Item item) {
    List<Item> sameTypeOfProducts;
    if (item.getProduct() instanceof AbstractGrocery) {
      sameTypeOfProducts = getGroceryStock()
          .get(item.getProduct().getProductType());//to discuss!!

    } else {
      sameTypeOfProducts = getHouseholdStock()
          .get(item.getProduct().getProductType());
    }
    return sameTypeOfProducts;
  }

  /**
   * Update the stock for each product customer buy.
   *
   * @param shoppingItem the item in the shopping cart
   */
  public void updateStock(Item shoppingItem) {
    List<Item> sameTypeOfProducts = getSameTypeOfProduct(shoppingItem);
    for (int i = 0; i < sameTypeOfProducts.size(); i++) {
      if (shoppingItem.getProduct().equals(sameTypeOfProducts.get(i).getProduct())) {
        sameTypeOfProducts.get(i).setQuantity(
            sameTypeOfProducts.get(i).getQuantity() - shoppingItem.getQuantity());
      }
    }
  }

  /**
   * Gets grocery stock.
   *
   * @return the grocery stock
   */
  public Map<String, List<Item>> getGroceryStock() {
    return groceryStock;
  }

  /**
   * Gets household stock.
   *
   * @return the household stock
   */
  public Map<String, List<Item>> getHouseholdStock() {
    return householdStock;
  }
}