package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CivilianTest {
  private String firstName;
  private String lastName;
  private Name name;
  private int age;
  private Civilian civilian;
  private static final int INITIAL_WEALTH = 0;

  @Before
  public void setUp() throws Exception {
    this.name = new Name(this.firstName, this.lastName);
    this.civilian = new Farmer(this.name, this.age);
  }

  @Test
  public void increaseWealth() throws Exception {
    int previousWealth = this.civilian.getWealth();
    int amount = 20;
    this.civilian.increaseWealth(amount);
    assertEquals(previousWealth + amount, this.civilian.getWealth());
  }

  @Test
  public void decreaseWealth() throws Exception {
    int increaseAmount = 30;
    int decreaseAmoutn = 20;
    this.civilian.increaseWealth(increaseAmount);
    this.civilian.decreaseWealth(decreaseAmoutn);
    assertEquals(increaseAmount - decreaseAmoutn + INITIAL_WEALTH, this.civilian.getWealth());
  }

  @Test
  public void getWealth() throws Exception {
    assertEquals(INITIAL_WEALTH, this.civilian.getWealth());
  }

  @Test(expected = IncorrectWealthValueException.class)
  public void increaseAmountNegative() throws Exception {
    this.civilian.increaseWealth(-1);
  }

  @Test(expected = IncorrectWealthValueException.class)
  public void decreaseAmountNegative() throws Exception {
    this.civilian.decreaseWealth(-1);
  }

  @Test(expected = IncorrectWealthValueException.class)
  public void invalidDecrease() throws Exception {
    this.civilian.decreaseWealth(1);
  }

}