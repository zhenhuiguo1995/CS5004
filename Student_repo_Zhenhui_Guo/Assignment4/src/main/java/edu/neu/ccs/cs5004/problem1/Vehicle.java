package edu.neu.ccs.cs5004.problem1;


/**
 * Represents details of a vehicle, including vehicle size and type.
 */
public class Vehicle {
  private Size size;
  private Type type;

  /**
   * Instantiates a new Vehicle.
   *
   * @param size the size
   * @param type the type
   */
  public Vehicle(Size size, Type type) {
    this.size = size;
    this.type = type;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public Size getSize() {
    return size;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public Type getType() {
    return type;
  }
}
