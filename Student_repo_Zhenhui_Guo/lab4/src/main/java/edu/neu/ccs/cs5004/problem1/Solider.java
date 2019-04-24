package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a solider, including stamina, name and age.
 */
public abstract class Solider extends Civilian {
  private int stamina;
  private static final int INITIAL_STAMINA = 30;

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   * @throws IncorrectAgeRangeException the incorrect age range exception
   */
  public Solider(Name name, int age) throws IncorrectAgeRangeException {
    super(name, age);
    this.stamina = INITIAL_STAMINA;
  }

  /**
   * Gets stamina.
   *
   * @return the stamina
   */
  public int getStamina() {
    return stamina;
  }

  /**
   * Increase stamina.
   *
   * @param amount the amount
   * @throws IncorrectStrengthValueException the incorrect strength value exception
   */
  public void increaseStamina(int amount) throws IncorrectStrengthValueException{
    if (amount < 0 || this.stamina + amount > 100) {
      throw new IncorrectStrengthValueException(amount);
    } else {
      this.stamina += amount;
    }

  }

  /**
   * Decrease stamina.
   *
   * @param amount the amount
   * @throws IncorrectStrengthValueException the incorrect strength value exception
   */
  public void decreaseStamina(int amount) throws IncorrectStrengthValueException{
    if (amount < 0 || this.stamina - amount < 0) {
      throw new IncorrectStrengthValueException(amount);
    } else {
      this.stamina -= amount;
    }

  }
}
