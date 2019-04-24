package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents details of a moving violation.
 */
public class MovingViolation {

  private Name driverName;
  private LocalDate date;
  private MovingViolationReason violation;

  /**
   * Instantiates a new movingViolation.
   *
   * @param name -- name of the driver.
   * @param date -- date the movingViolation.
   * @param violation -- reason of the violation.
   */
  public MovingViolation(Name name, LocalDate date, MovingViolationReason violation) {
    this.driverName = name;
    this.date = date;
    this.violation = violation;
  }

  /**
   * Get the driver name.
   *
   * @return driverName
   */
  public Name getDriverName() {
    return driverName;
  }

  /**
   * Get the date.
   *
   * @return date
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Get the violation reason.
   *
   * @return violation.
   */
  public MovingViolationReason getViolation() {
    return violation;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "MovingViolation{"
        + "driverName=" + driverName
        + ", date=" + date
        + ", violation=" + violation
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
    MovingViolation that = (MovingViolation) object;
    return Objects.equals(driverName, that.driverName)
        && Objects.equals(date, that.date)
        && violation == that.violation;
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(driverName, date, violation);
  }
}
