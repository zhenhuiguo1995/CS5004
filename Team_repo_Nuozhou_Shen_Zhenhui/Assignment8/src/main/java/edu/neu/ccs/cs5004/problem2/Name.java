package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * Represents details of a name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Instantiates a new Name.
   *
   * @param firstName -- the first name.
   * @param lastName -- the last name.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the first name.
   *
   * @return firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Get the last name.
   *
   * @return lastName.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Name{"
        + "firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + '}';
  }

  /**
   * Check if equals.
   *
   * @param object -- to be checked object.
   * @return true if two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Name name = (Name) object;
    return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }


}
