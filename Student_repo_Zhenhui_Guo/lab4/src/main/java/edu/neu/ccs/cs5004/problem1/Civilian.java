package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a civilian, including wealth, name and age.
 */
public abstract class Civilian extends Piece {
  private int wealth;
  private static final int INITIAL_WEALTH = 0;

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   * @throws IncorrectAgeRangeException the incorrect age range exception
   */
  public Civilian(Name name, int age) throws IncorrectAgeRangeException {
    super(name, age);
    this.wealth = INITIAL_WEALTH;
  }

  /**
   * Increase wealth.
   *
   * @param amount the amount
   * @throws IncorrectWealthValueException the incorrect wealth value exception
   */
  public void increaseWealth(int amount) throws IncorrectWealthValueException {
    if (amount < 0) {
      throw new IncorrectWealthValueException(amount);
    } else {
      this.wealth += amount;
    }
  }

  /**
   * Decrease wealth.
   *
   * @param amount the amount
   * @throws IncorrectWealthValueException the incorrect wealth value exception
   */
  public void decreaseWealth(int amount) throws IncorrectWealthValueException {
    if (amount < 0 || this.wealth - amount < 0) {
      throw new IncorrectWealthValueException(amount);
    } else {
      this.wealth -= amount;
    }
  }

  /**
   * Gets wealth.
   *
   * @return the wealth
   */
  public int getWealth() {
    return wealth;
  }
}
