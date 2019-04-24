package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of an incorrect wealth range exception, including wealth.
 */
public class IncorrectWealthValueException extends Exception{
  private int wealth;

  /**
   * Instantiates a new Incorrect wealth value exception.
   *
   * @param wealth the wealth
   */
  public IncorrectWealthValueException(int wealth) {
    this.wealth = wealth;
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
