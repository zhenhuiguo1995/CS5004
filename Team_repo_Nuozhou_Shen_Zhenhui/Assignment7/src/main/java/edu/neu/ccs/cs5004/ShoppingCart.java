package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * Represents details of a shopping cart.
 */
public class ShoppingCart {

  private List<Item> shoppingList;
  private double totalPrice;

  /**
   * Instantiates a new shopping cart.
   *
   * @param shoppingList -- a list of shopping list.
   */
  public ShoppingCart(List<Item> shoppingList) {
    this.shoppingList = shoppingList;
    this.totalPrice = calculateTotalPrice();

  }

  /**
   * calcuate the total price.
   *
   * @return total price.
   */
  public double calculateTotalPrice() {
    double totalPrice = 0;
    for (Item item : shoppingList) {
      totalPrice += item.getItemPrice();
    }
    return totalPrice;
  }

  /**
   * Get the total price.
   *
   * @return total price.
   */
  public double getTotalPrice() {
    this.totalPrice = calculateTotalPrice();
    return this.totalPrice;
  }

  /**
   * Get the shopping cart list.
   *
   * @return the shopping cart list.
   */
  public List<Item> getShoppingList() {
    return this.shoppingList;
  }

  /**
   * Add item into Shopping cart.
   *
   * @param product -- product to be added into shopping cart.
   * @param quantity -- quantity of product to be added.
   * @param inventory -- current inventory of the supermarket.
   */
  public void addShoppingCartItem(AbstractProduct product, int quantity, Inventory inventory) {
    Item newItem = new ShoppingCartItem(product, quantity);
    if (inventory.isInStock(newItem)) {
      this.shoppingList.add(newItem);
    } else {
      throwAnException();
    }
  }

  /**
   * Throw exception if out of stock.
   *
   * @throws IllegalArgumentException -- throw expeption.
   */
  public void throwAnException() throws IllegalArgumentException {
    throw new OutOfStockException("Error:Out of stock");
  }

  /**
   * To fulfill the order, substitute the product out of stock with other product in the same type,
   * or remove them if no product to replace.
   *
   * @param inventory the inventory
   * @return return the result of the order fulfillment
   */
  public FulfillOrderResult fulfillOrder(Inventory inventory) {
    List<Item> items = getShoppingList();
    FulfillOrderResult result = new FulfillOrderResult();
    for (Item item : items) {
      if (!inventory.isInStock(item)) {
        result.addOutOfStockProduct((new ReceiptItem(item.getProduct(), item.getQuantity())));
        if (!substitute(item, inventory)) {
          result.addRemovedProduct(new ReceiptItem(item.getProduct(), item.getQuantity()));
        }
      }
    }
    return result;
  }

  /**
   * Helper method to Substitute the product that is out of stock.
   *
   * @param shoppingItem the item that is out of stock
   * @return true if find one substitute product, false if no product found
   */
  private boolean substitute(Item shoppingItem, Inventory inventory) {
    List<Item> sameTypeOfProducts = inventory.getSameTypeOfProduct(shoppingItem);
    for (int i = 0; i < sameTypeOfProducts.size(); i++) {
      if (shoppingItem.getProduct().equals(sameTypeOfProducts.get(i).getProduct())) {
        continue;
      } else if (((StockItem) (sameTypeOfProducts.get(i))).isQualifiedToSubstitute(shoppingItem)) {
        shoppingItem.setProduct(sameTypeOfProducts.get(i).getProduct());
        return true;
      }
    }
    return false;
  }
}