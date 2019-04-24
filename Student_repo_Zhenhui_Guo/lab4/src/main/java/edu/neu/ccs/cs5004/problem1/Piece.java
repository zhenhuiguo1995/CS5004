package edu.neu.ccs.cs5004.problem1;

/**
 * The type Piece.
 */
public abstract class Piece {
  private Name name;
  private int age;

  /**
   * Instantiates a new Piece.
   *
   * @param name the name
   * @param age the age
   */
  public Piece(Name name, int age) throws IncorrectAgeRangeException {
    if (age < 0 || age > 128) {
      throw new IncorrectAgeRangeException(age);
    } else {
    this.name = name;
    this.age = age;
    }
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public Name getName() {
    return name;
  }

  /**
   * Gets age.
   *
   * @return the age
   */
  public int getAge() {
    return age;
  }
}
