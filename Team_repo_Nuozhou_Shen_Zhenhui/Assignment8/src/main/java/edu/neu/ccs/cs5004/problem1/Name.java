package edu.neu.ccs.cs5004.problem1;

/**
 * This represents a name for a person.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Create a name given the first name and last name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Name that = (Name) obj;
    return this.getFirstName().equals(that.getFirstName())
        && this.getLastName().equals(that.getLastName());
  }

  @Override
  public int hashCode() {
    String str = firstName + " " + lastName;
    return str.hashCode();
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
