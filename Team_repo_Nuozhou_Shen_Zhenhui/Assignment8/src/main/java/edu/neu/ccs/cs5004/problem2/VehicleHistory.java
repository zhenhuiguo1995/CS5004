package edu.neu.ccs.cs5004.problem2;

import java.util.List;
import java.util.Objects;

/**
 * Represents details of a vehicle's history.
 */
public class VehicleHistory {

  private List<MovingViolation> movingViolationList;
  private List<NonMovingViolation> nonMovingViolationList;
  private List<Crash> crashList;

  /**
   * Instantiates a new VehicleHistory.
   *
   * @param movingViolationList -- movingViolation list.
   * @param nonMovingViolationList -- nonMovingViolation list.
   * @param crashList -- crash list.
   */
  public VehicleHistory(List<MovingViolation> movingViolationList,
      List<NonMovingViolation> nonMovingViolationList,
      List<Crash> crashList) {
    this.movingViolationList = movingViolationList;
    this.nonMovingViolationList = nonMovingViolationList;
    this.crashList = crashList;
  }

  /**
   * Get the movingViolationList.
   *
   * @return movingViolationList
   */
  public List<MovingViolation> getMovingViolationList() {
    return movingViolationList;
  }

  /**
   * Get the crashList.
   *
   * @return crashList
   */
  public List<Crash> getCrashList() {
    return crashList;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "VehicleHistory{"
        + "movingViolationList=" + movingViolationList
        + ", nonMovingViolationList=" + nonMovingViolationList
        + ", crashList=" + crashList
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
    VehicleHistory that = (VehicleHistory) object;
    return Objects.equals(movingViolationList, that.movingViolationList)
        && Objects.equals(nonMovingViolationList, that.nonMovingViolationList)
        && Objects.equals(crashList, that.crashList);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(movingViolationList, nonMovingViolationList, crashList);
  }
}
