package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * Represents details of an applicant.
 */
public class Applicant {

  private Driver driver;
  private DriverLicense driverLicense;
  private Vehicle vehicle;
  private Insurance insurance;


  /**
   * Instantiates a new Applicant.
   *
   * @param driver -- driver stated in the applicant
   * @param driverLicense -- driver's license
   * @param vehicle -- vehicle stated in the applicant
   * @param insurance -- insurance of the vehicle
   */
  public Applicant(Driver driver, DriverLicense driverLicense, Vehicle vehicle,
      Insurance insurance) {
    this.driver = driver;
    this.driverLicense = driverLicense;
    this.vehicle = vehicle;
    this.insurance = insurance;
  }

  /**
   * Get the driver.
   *
   * @return the driver.
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Get the driverLicense.
   *
   * @return the driverLicense.
   */
  public DriverLicense getDriverLicense() {
    return driverLicense;
  }

  /**
   * Get the vehicle.
   *
   * @return the vehicle.
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Get the insurance information.
   *
   * @return the insurance information
   */
  public Insurance getInsurance() {
    return insurance;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Applicant{"
        + "driver=" + driver
        + ", driverLicense=" + driverLicense
        + ", vehicle=" + vehicle
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
    Applicant applicant = (Applicant) object;
    return Objects.equals(driver, applicant.driver)
        && Objects.equals(driverLicense, applicant.driverLicense)
        && Objects.equals(vehicle, applicant.vehicle);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(driver, driverLicense, vehicle);
  }
}
