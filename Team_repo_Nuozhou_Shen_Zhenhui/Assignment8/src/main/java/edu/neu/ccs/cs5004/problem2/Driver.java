package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;

/**
 * Represents details of a driver.
 */
public class Driver extends Person {
  private DriverHistory history;

  /**
   * Instantiates a new Driver.
   *
   * @param name -- name of the driver.
   * @param birthday -- birthday of the driver.
   * @param history -- driver history.
   */
  public Driver(Name name, LocalDate birthday, DriverHistory history) {
    super(name, birthday);
    this.history = history;

  }

  /**
   * Get the driver's history.
   *
   * @return the history
   */
  public DriverHistory getHistory() {
    return history;
  }

/*  *//**
   * Get toString.
   *
   * @return string
   *//*
  @Override
  public String toString() {
    return "Driver{"
        + "name=" + name
        + ", birthday=" + birthday
        + ", history=" + history
        + '}';

  }

  *//**
   * Check if equals.
   *
   * @param object -- to be checked object.
   * @return true if two objects are equal, false otherwise.
   *//*
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    Driver driver = (Driver) object;
    return Objects.equals(name, driver.name)
        && Objects.equals(birthday, driver.birthday)
        && Objects.equals(history, driver.history);
  }

  *//**
   * Get the hashCode.
   *
   * @return hashCode.
   *//*
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, birthday, history);
  }*/

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }

    Driver driver = (Driver) object;

    return getHistory() != null ? getHistory().equals(driver.getHistory())
        : driver.getHistory() == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (getHistory() != null ? getHistory().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Driver{"
        + "history=" + history
        + '}';
  }
}
