package assignment3;

import static org.junit.Assert.*;

import assignment3.Menu;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {
  private String meals;
  private String desserts;
  private String beverages;
  private String drinks;
  private Menu menu;

  @Before
  public void setUp() throws Exception {
    this.meals = "Roasted duck";
    this.desserts = "Handmade cupcakes";
    this.beverages = "wine";
    this.drinks = "yogurt";
    this.menu = new Menu(meals, desserts, beverages, drinks);
  }

  @Test
  public void getMeals() throws Exception {
    assertEquals(this.meals, this.menu.getMeals());
  }

  @Test
  public void setMeals() throws Exception {
    String meals = "Fried chicken party wings";
    this.menu.setMeals(meals);
    assertEquals(meals, this.menu.getMeals());

  }

  @Test
  public void getDesserts() throws Exception {
    assertEquals(this.desserts, this.menu.getDesserts());
  }

  @Test
  public void setDesserts() throws Exception {
    String desserts = "Strawberry pudding";
    this.menu.setDesserts(desserts);
    assertEquals(desserts, this.menu.getDesserts());
  }

  @Test
  public void getBeverages() throws Exception {
    assertEquals(this.beverages, this.menu.getBeverages());
  }

  @Test
  public void setBeverages() throws Exception {
    String beverages = "sweet wine";
    this.menu.setBeverages(beverages);
    assertEquals(beverages, this.menu.getBeverages());
  }

  @Test
  public void getDrinks() throws Exception {
    assertEquals(this.drinks, this.menu.getDrinks());
  }

  @Test
  public void setDrinks() throws Exception {
    String drinks = "watermelon juice";
    this.menu.setDrinks(drinks);
    assertEquals(drinks, this.menu.getDrinks());
  }

}