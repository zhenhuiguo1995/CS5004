package problem2;

/**
 * Represents detailed information of the owner
 *
 * @author Alfred
 */
public class Owner {
  private String firstName;
  private String lastName;
  private String address;
  private String email;

  /**
   * Creates an owner of the gift card.
   *
   * @param firstName the first name of the owner.
   * @param lastName the last name of the owner.
   * @param address the physical address of the owner.
   * @param email the email address of the owner.
   */
  public Owner(String firstName, String lastName, String address, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
  }

  /**
   * @return the first name of the owner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the last name of the owner.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return the physical address of the owner.
   */
  public String getAddress() {
    return address;
  }

  /**
   * @return the email address of the owner.
   */
  public String getEmail() {
    return email;
  }
}
