package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Represents details of insurance.
 */
public class Insurance {

  private Person owner;
  private List<Person> coverList;
  private LocalDate expirationDate;

  /**
   * Instantiates a new Insurance.
   *
   * @param owner -- the owner of the vehicle
   * @param coverList -- the list of people covered by the insurance
   * @param expirationDate -- the expiration date
   */
  public Insurance(Person owner, List<Person> coverList, LocalDate expirationDate) {
    this.owner = owner;
    this.coverList = coverList;
    this.expirationDate = expirationDate;
  }

  /**
   * Get the owner.
   *
   * @return the owner
   */
  public Person getOwner() {
    return owner;
  }

  /**
   * Get the coverList.
   *
   * @return the coverList
   */
  public List<Person> getCoverList() {
    return coverList;
  }

  /**
   * Get the expirationDate.
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
    return "Insurance{"
        + "owner=" + owner
        + ", coverList=" + coverList
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
    Insurance insurance = (Insurance) object;
    return Objects.equals(owner, insurance.owner)
        && Objects.equals(coverList, insurance.coverList)
        && Objects.equals(expirationDate, insurance.expirationDate);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(owner, coverList, expirationDate);
  }
}
