package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * Represents details of a vehicle.
 */
public class Vehicle {

  private String make;
  private String model;
  private int year;
  private Person owner;
  private VehicleHistory vehicleHistory;

  /**
   * Instantiates a new Vehicle.
   *
   * @param make -- make of the vehicle
   * @param model -- model of the vehicle
   * @param year -- year of the vehicle
   * @param owner -- owner of the vehicle
   * @param vehicleHistory -- history of the vehicle
   */
  public Vehicle(String make, String model, int year, Person owner, VehicleHistory vehicleHistory) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.owner = owner;
    this.vehicleHistory = vehicleHistory;
  }


  /**
   * Get the year.
   *
   * @return year
   */
  public int getYear() {
    return year;
  }

  /**
   * Get the owner.
   *
   * @return owner
   */
  public Person getOwner() {
    return owner;
  }

  /**
   * Get the vehicle history.
   *
   * @return vehicleHistory
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Vehicle{"
        + "make='" + make + '\''
        + ", model='" + model + '\''
        + ", year=" + year
        + ", owner=" + owner
        + ", vehicleHistory=" + vehicleHistory
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
    Vehicle vehicle = (Vehicle) object;
    return year == vehicle.year
        && Objects.equals(make, vehicle.make)
        && Objects.equals(model, vehicle.model)
        && Objects.equals(owner, vehicle.owner)
        && Objects.equals(vehicleHistory, vehicle.vehicleHistory);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, owner, vehicleHistory);
  }
}
