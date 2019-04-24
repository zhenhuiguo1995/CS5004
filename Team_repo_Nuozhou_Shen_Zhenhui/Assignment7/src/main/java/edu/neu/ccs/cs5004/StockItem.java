package edu.neu.ccs.cs5004;

/**
 * Represents details of a stock item, including product and quantity.
 */
public class StockItem extends Item {

  /**
   * Instantiates a new Stock item.
   *
   * @param product the product
   * @param quantity the quantity
   */
  public StockItem(AbstractProduct product, int quantity) {
    super(product, quantity);
  }

  public boolean checkItem(int purchaseNumber) {
    return this.quantity >= purchaseNumber;
  }

  /**
   * Helper method to check if the product in stock is qualified to substitute the item in shopping
   * cart.
   *
   * @param shoppingItem the product need to be substituted
   * @return true if qualified, false if not
   */
  public boolean isQualifiedToSubstitute(Item shoppingItem) {
    if (shoppingItem.getQuantity() > getQuantity()
        || shoppingItem.getProduct().getPrice() < getProduct().getPrice()) {
      return false;
    }
    if (shoppingItem.getProduct() instanceof AbstractGrocery) {
      if (((AbstractGrocery) shoppingItem.getProduct()).getWeight()
          > ((AbstractGrocery) (getProduct())).getWeight()) {
        return false;
      }
    } else if (shoppingItem
        .getProduct() instanceof AbstractHousehold) { // no need for the "if" here
      if (((AbstractHousehold) shoppingItem.getProduct()).getUnits()
          > ((AbstractHousehold) (getProduct())).getUnits()) {
        return false;
      }
    }
    return true;
  }
}
