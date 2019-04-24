package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a marine.
 */
public class Marine extends Solider {

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   * @throws IncorrectAgeRangeException the incorrect age range exception
   */
  public Marine(Name name, int age) throws IncorrectAgeRangeException {
    super(name, age);
  }
}
