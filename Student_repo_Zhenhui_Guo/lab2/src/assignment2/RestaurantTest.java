package assignment2;

import static org.junit.Assert.*;

import assignment2.Restaurant;
import assignment3.Menu;
import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {
  private String name;
  private String address;
  private boolean status;
  private Menu menu;
  private Restaurant restaurant;

  @Before
  public void setUp() throws Exception {
    this.name = "Spice up";
    this.address = "122 Titan Ave.";
    this.status = true;
    this.menu = new Menu("baked pork", "yogurt icecream",
        "sweet lemenade jucie", "grape wine");
    this.restaurant = new Restaurant(name, address, status, menu);

  }

  @Test
  public void getName() throws Exception {
    assertEquals(this.name, this.restaurant.getName());
  }

  @Test
  public void setName() throws Exception {
    String name = "Hotpot";
    this.restaurant.setName(name);
    assertEquals(name, this.restaurant.getName());

  }

  @Test
  public void getAddress() throws Exception {
    assertEquals(this.address, this.restaurant.getAddress());
  }

  @Test
  public void setAddress() throws Exception {
    String address = "1029 Aurora Ave";
    this.restaurant.setAddress(address);
    assertEquals(address, this.restaurant.getAddress());
  }

  @Test
  public void isStatus() throws Exception {
    assertEquals(this.status, this.restaurant.isStatus());
  }

  @Test
  public void setStatus() throws Exception {
    this.restaurant.setStatus(false);
    assertEquals(false, this.restaurant.isStatus());
  }

  @Test
  public void getMenu() throws Exception {
    assertEquals(this.menu.getMeals(), this.restaurant.getMenu().getMeals());
    assertEquals(this.menu.getBeverages(), this.restaurant.getMenu().getBeverages());
    assertEquals(this.menu.getDesserts(), this.restaurant.getMenu().getDesserts());
    assertEquals(this.menu.getDrinks(), this.restaurant.getMenu().getDrinks());
  }


}