package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of an incorrect age range exception, including age.
 */
public class IncorrectAgeRangeException extends Exception {
  private int age;

  /**
   * Instantiates a new Incorrect age range exception.
   *
   * @param age the age
   */
  public IncorrectAgeRangeException(int age) {
    this.age = age;
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
