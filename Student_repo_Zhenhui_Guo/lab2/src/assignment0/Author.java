package assignment0;

/**
 * Represents an author with the details: name, email and address
 *
 * @author Alfred
 */
public class Author {
  private String name;
  private String email;
  private String address;

  /**
   * Creates a new author given the name, email and address as Strings.
   *
   * @param name the author's name.
   * @param email the author's email address.
   * @param address the author's physical address.
   */
  public Author(String name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }

  /**
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * @return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return the physical address.
   */
  public String getAddress() {
    return address;
  }
}
