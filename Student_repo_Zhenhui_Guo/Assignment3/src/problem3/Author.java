package problem3;

/**
 * Represents details of an author, including first name and last name.
 */
public class Author {
  private String firstName;
  private String lastName;

  /**
   * Instantiates a new Author.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Author(String firstName, String lastName) {
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
