package edu.neu.ccs.cs5004;

/**
 * Represents details of a customer's name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Instantiates a new Customer's name.
   *
   * @param firstName -- the first name of the customer.
   * @param lastName -- the last name of the customer.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
