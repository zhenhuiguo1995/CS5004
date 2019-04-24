package edu.neu.ccs.cs5004.problem1;

/**
 * Represent details of a farmer.
 */
public class Farmer extends Civilian {

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   * @throws IncorrectAgeRangeException the incorrect age range exception
   */
  public Farmer(Name name, int age) throws IncorrectAgeRangeException {
    super(name, age);
  }
}
