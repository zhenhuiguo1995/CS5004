package edu.neu.ccs.cs5004;

/**
 * Represents details of a customer.
 */
public class Customer {

  private Name name;
  private int age;
  private ShoppingCart shoppingCart;
  private static final int DEFAULT_QUANTITY = 1;

  /**
   * Instantiates a new Customer.
   *
   * @param name -- name of the customer.
   * @param age -- age of the customer.
   * @param shoppingCart -- shopping cart of the customer.
   */
  public Customer(Name name, int age, ShoppingCart shoppingCart) {
    this.name = name;
    this.age = age;
    this.shoppingCart = shoppingCart;
  }

  /**
   * Get the name of the customer.
   *
   * @return Name -- name of the customer.
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Get the age of the customer.
   *
   * @return age -- customer's age.
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Get the shopping cart of the customer.
   *
   * @return the customer's shopping cart.
   */
  public ShoppingCart getShoppingCart() {
    return this.shoppingCart;
  }


  /**
   * Add item into Shopping cart.
   *
   * @param product -- product to be added into shopping cart.
   * @param inventory -- current inventory of the supermarket.
   */
  public void addItem(AbstractProduct product, Inventory inventory) {
    this.shoppingCart.addShoppingCartItem(product, DEFAULT_QUANTITY, inventory);
  }

  /**
   * Add item into Shopping cart.
   *
   * @param product -- product to be added into shopping cart.
   * @param quantity -- quantity of product to be added.
   * @param inventory -- current inventory of the supermarket.
   */
  public void addItem(AbstractProduct product, int quantity, Inventory inventory) {
    this.shoppingCart.addShoppingCartItem(product, quantity, inventory);
  }

  /**
   * Check if the customer is old enough to buy the item.
   *
   * @param shoppingItem the item that is being checked
   * @return true if the customer is old enough to buy the item, vice versa
   */
  public boolean isOldEnoughToBuy(Item shoppingItem) {
    if (shoppingItem.getProduct().getMinimumAge() > getAge()) {
      return false;
    }
    return true;
  }
}