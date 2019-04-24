package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a name, including first name and last name.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Instantiates a new Name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }
}
