package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a sniper.
 */
public class Sniper extends Solider {

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   * @throws IncorrectAgeRangeException the incorrect age range exception
   */
  public Sniper(Name name, int age) throws IncorrectAgeRangeException {
    super(name, age);
  }
}
