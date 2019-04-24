package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of an incorrect strength range exception, including strength.
 */
public class IncorrectStrengthValueException extends Exception{
  private int strength;

  /**
   * Instantiates a new Incorrect strength value exception.
   *
   * @param wealth the wealth
   */
  public IncorrectStrengthValueException(int wealth) {
    this.strength = wealth;
  }

  /**
   * Gets strength.
   *
   * @return the strength
   */
  public int getStrength() {
    return strength;
  }
}
