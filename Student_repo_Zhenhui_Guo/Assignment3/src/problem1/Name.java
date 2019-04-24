package problem1;

/**
 * Represents details of a name, including first name and last name.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Creates a name given first name and last name.
   *
   * @param firstName the first name.
   * @param lastName the last name.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }
}
