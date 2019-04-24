package edu.neu.ccs.cs5004.problem1;

/**
 * Represent details of a parking spot, including size, status and type.
 */
public class ParkingSpot {
  private Size size;
  private ParkingSpotStatus parkingSpotStatus;
  private Type type;

  /**
   * Instantiates a new Parking spot.
   *
   * @param size the size
   * @param parkingSpotStatus the parking spot status
   * @param type the type
   */
  public ParkingSpot(Size size, ParkingSpotStatus parkingSpotStatus,
      Type type) {
    this.size = size;
    this.parkingSpotStatus = parkingSpotStatus;
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
   * Gets parking spot status.
   *
   * @return the parking spot status
   */
  public ParkingSpotStatus getParkingSpotStatus() {
    return parkingSpotStatus;
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
