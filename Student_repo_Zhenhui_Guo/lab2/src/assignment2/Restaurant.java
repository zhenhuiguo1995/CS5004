package assignment2;


import assignment3.Menu;

/**
 * Represents detailed information of a restaurant, including name, address and opening/close status
 *
 * @author Alfred
 */
public class Restaurant {
  private String name;
  private String address;
  private boolean status;
  private Menu menu;

  /**
   * Creates a restaurant, given two Strings and one Boolean.
   *
   * @param name the name of the restaurant.
   * @param address the address of the restaurant.
   * @param status the status of the restaurant.
   */
  public Restaurant(String name, String address, boolean status, Menu menu) {
    this.name = name;
    this.address = address;
    this.status = status;
    this.menu = menu;
  }

  /**
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   * @param name the name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   * @param address the address.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the status.
   */
  public boolean isStatus() {
    return status;
  }

  /**
   * Sets the status.
   * @param status
   */
  public void setStatus(boolean status) {
    this.status = status;
  }

  /**
   * @return the menu.
   */
  public Menu getMenu() {
    return menu;
  }
}
