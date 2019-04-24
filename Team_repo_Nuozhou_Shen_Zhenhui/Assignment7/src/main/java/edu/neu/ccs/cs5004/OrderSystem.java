package edu.neu.ccs.cs5004;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents an order system which can fulfill and process the order.
 */
public class OrderSystem {

  private Inventory inventory;

  /**
   * Create the order system.
   *
   * @param inventory the inventory contains the stock of the items
   */
  public OrderSystem(Inventory inventory) {
    this.inventory = inventory;
  }

  /**
   * Process the the order: remove the products that the customer is not old enough to buy, update
   * the quantity of purchased product in inventory, empty the shopping cart and give the receipt.
   * @param customer the customer
   * @return the receipt for this order
   */
  public Receipt process(Customer customer) {
    FulfillOrderResult fulFillResult = customer.getShoppingCart().fulfillOrder(inventory);
    List<Item> removedProducts = new LinkedList<>();
    for (Item shoppingItem : customer.getShoppingCart().getShoppingList()) {
      if (!customer.isOldEnoughToBuy(shoppingItem)) {
        customer.getShoppingCart().getShoppingList().remove(shoppingItem);
        removedProducts.add(new ReceiptItem(
            shoppingItem.getProduct(), shoppingItem.getQuantity()));
      }
      inventory.updateStock(shoppingItem);
    }
    return buildReceipt(customer, fulFillResult, removedProducts);
  }

  /**
   * A helper method to build the receipt.
   *
   * @param customer the customer
   * @param fulfillOrderResult the result of method fulfill order
   * @param removedProducts the removed products from processing
   * @return the receipt
   */
  private Receipt buildReceipt(Customer customer, FulfillOrderResult fulfillOrderResult,
      List<Item> removedProducts) {
    removedProducts.addAll(fulfillOrderResult.getRemovedProducts());
    List<Item> receivedItem = new LinkedList<>();
    for (Item item : customer.getShoppingCart().getShoppingList()) {
      receivedItem.add(new ReceiptItem(item.getProduct(), item.getQuantity()));
    }
    Receipt receipt = new Receipt(receivedItem, fulfillOrderResult.getOutOfStockProducts(),
        removedProducts);
    return receipt;
  }
}
