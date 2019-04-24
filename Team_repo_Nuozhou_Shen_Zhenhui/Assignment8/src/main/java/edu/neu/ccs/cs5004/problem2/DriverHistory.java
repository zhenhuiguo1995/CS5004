package edu.neu.ccs.cs5004.problem2;

import java.util.List;
import java.util.Objects;

/**
 * Represents details of a driver history.
 */
public class DriverHistory {

  private List<MovingViolation> movingViolationList;
  private List<NonMovingViolation> nonMovingViolationList;

  /**
   * Instantiates a new DriverHistory.
   *
   * @param movingViolationList -- moving violation list
   * @param nonMovingViolationList -- non-moving violation list
   */
  public DriverHistory(List<MovingViolation> movingViolationList,
      List<NonMovingViolation> nonMovingViolationList) {
    this.movingViolationList = movingViolationList;
    this.nonMovingViolationList = nonMovingViolationList;
  }

  /**
   * Get the movingAbstractViolationList.
   *
   * @return movingAbstractViolationList
   */
  public List<MovingViolation> getMovingViolationList() {
    return movingViolationList;
  }

  /**
   * Get the non-moving violation list.
   *
   * @return non-moving violation list
   */
  public List<NonMovingViolation> getNonMovingAbstractViolationList() {
    return nonMovingViolationList;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "DriverHistory{"
        + "movingAbstractViolationList=" + movingViolationList
        + ", nonMovingAbstractViolationList=" + nonMovingViolationList
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
    DriverHistory that = (DriverHistory) object;
    return Objects.equals(movingViolationList, that.movingViolationList)
        && Objects.equals(nonMovingViolationList, that.nonMovingViolationList);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(movingViolationList, nonMovingViolationList);
  }
}
