package assignment3;

/**
 * Represents the details of the menu, including meals, desserts, beverages and drinks.
 *
 * @author Alfred
 */
public class Menu {
  private String meals;
  private String desserts;
  private String beverages;
  private String drinks;

  /**
   * Creates a menu, given the meals, desserts, beverages and drinks as Strings.
   *
   * @param meals the meals of the menu.
   * @param desserts the desserts of the menu.
   * @param beverages the beverages of the menu.
   * @param drinks the drinks of the menu.
   */
  public Menu(String meals, String desserts, String beverages, String drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  /**
   * @return the meals.
   */
  public String getMeals() {
    return meals;
  }

  /**
   * Sets the meals.
   * @param meals the meals.
   */
  public void setMeals(String meals) {
    this.meals = meals;
  }

  /**
   * @return the desserts.
   */
  public String getDesserts() {
    return desserts;
  }

  /**
   * Sets the desserts.
   * @param desserts the desserts
   */
  public void setDesserts(String desserts) {
    this.desserts = desserts;
  }

  /**
   * @return the beverages
   */
  public String getBeverages() {
    return beverages;
  }

  /**
   * Sets the beverages.
   * @param beverages the beverages.
   */
  public void setBeverages(String beverages) {
    this.beverages = beverages;
  }

  /**
   * @return the drinks.
   */
  public String getDrinks() {
    return drinks;
  }

  /**
   * Sets the drinks.
   * @param drinks the drinks.
   */
  public void setDrinks(String drinks) {
    this.drinks = drinks;
  }
}
