package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoliderTest {
  private String firstName;
  private String lastName;
  private Name name;
  private int age;
  private Solider solider;
  private static final int INITIAL_STAMINA = 30;

  @Before
  public void setUp() throws Exception {
    this.name = new Name(this.firstName, this.lastName);
    this.solider = new Sniper(this.name, this.age);
  }


  @Test
  public void getStamina() throws Exception {
    assertEquals(INITIAL_STAMINA, this.solider.getStamina());
  }

  @Test
  public void increaseStamina() throws Exception {
    int increment = 20;
    this.solider.increaseStamina(increment);
    assertEquals(INITIAL_STAMINA + increment, this.solider.getStamina());
  }

  @Test
  public void decreaseStamina() throws Exception {
    int decrement = 20;
    this.solider.decreaseStamina(decrement);
    assertEquals(INITIAL_STAMINA - decrement, this.solider.getStamina());
  }

  @Test(expected = IncorrectStrengthValueException.class)
  public void increaseAmountNegative() throws Exception {
    int increment = -1;
    this.solider.increaseStamina(increment);
  }

  @Test(expected = IncorrectStrengthValueException.class)
  public void increaseAmountOverflow() throws Exception {
    int increment = 81;
    this.solider.increaseStamina(increment);
  }

  @Test(expected = IncorrectStrengthValueException.class)
  public void decreaseAmountNegative() throws Exception {
    int decrement = -1;
    this.solider.decreaseStamina(decrement);
  }

  @Test(expected = IncorrectStrengthValueException.class)
  public void decreaseAmountOverflow() throws Exception {
    int decrement = INITIAL_STAMINA + 1;
    this.solider.decreaseStamina(decrement);
  }

}