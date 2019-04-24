package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents details of a driver license.
 */
public class DriverLicense {

  private String number;
  private Name name;
  private String address;
  private LocalDate birthday;
  private Country country;
  private String state;
  private LocalDate issuanceDate;
  private LocalDate expirationDate;

  /**
   * Instantiates a new Driver License.
   *
   * @param number -- license number
   * @param name -- driver's name
   * @param address -- driver's address
   * @param birthday -- driver's birthday
   * @param country -- country of issuance
   * @param state -- state of issuance
   * @param issuanceDate -- issuance date
   * @param expirationDate -- expiration date
   */
  public DriverLicense(String number, Name name, String address, LocalDate birthday,
      Country country,
      String state, LocalDate issuanceDate, LocalDate expirationDate) {
    this.number = number;
    this.name = name;
    this.address = address;
    this.birthday = birthday;
    this.country = country;
    this.state = state;
    this.issuanceDate = issuanceDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Get the driver's name.
   *
   * @return name
   */
  public Name getName() {
    return name;
  }

  /**
   * Get the driver's birthday.
   *
   * @return birthday
   */
  public LocalDate getBirthday() {
    return birthday;
  }

  /**
   * Get the country of issuance.
   *
   * @return the country
   */
  public Country getCountry() {
    return country;
  }

  /**
   * Get the date of issuance.
   *
   * @return the date
   */
  public LocalDate getIssuanceDate() {
    return issuanceDate;
  }

  /**
   * Get the expiration date.
   *
   * @return expirationDate
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "DriverLicense{"
        + "number='" + number + '\''
        + ", name=" + name
        + ", address='" + address + '\''
        + ", birthday=" + birthday
        + ", country='" + country + '\''
        + ", state='" + state + '\''
        + ", issuanceDate=" + issuanceDate
        + ", expirationDate=" + expirationDate
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
    DriverLicense that = (DriverLicense) object;
    return Objects.equals(number, that.number)
        && Objects.equals(name, that.name)
        && Objects.equals(address, that.address)
        && Objects.equals(birthday, that.birthday)
        && Objects.equals(country, that.country)
        && Objects.equals(state, that.state)
        && Objects.equals(issuanceDate, that.issuanceDate)
        && Objects.equals(expirationDate, that.expirationDate);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(number, name, address, birthday, country, state, issuanceDate, expirationDate);
  }
}
