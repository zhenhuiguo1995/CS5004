package assignment1;

/**
 * Represents an author class which inherits from the Person class.
 *
 * @author Alfred
 */
public class Author extends Person {
  private String email;
  private String address;


  /**
   * Creats a person given the first name and last name,
   * email address and physical address.
   *
   * @param firstName the author's first name.
   * @param lastName the author's last name.
   * @param email the author's email address.
   * @param address the author's physical address.
   */
  public Author(String firstName, String lastName, String email, String address) {
    super(firstName, lastName);
    this.email = email;
    this.address = address;
  }

  /**
   * @return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return the address.
   */
  public String getAddress() {
    return address;
  }
}
