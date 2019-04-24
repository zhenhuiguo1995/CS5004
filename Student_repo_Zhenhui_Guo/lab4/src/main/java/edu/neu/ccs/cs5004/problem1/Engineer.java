package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of an engineer.
 */
public class Engineer extends Civilian {

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   * @throws IncorrectAgeRangeException the incorrect age range exception
   */
  public Engineer(Name name, int age) throws IncorrectAgeRangeException {
    super(name, age);
  }
}
