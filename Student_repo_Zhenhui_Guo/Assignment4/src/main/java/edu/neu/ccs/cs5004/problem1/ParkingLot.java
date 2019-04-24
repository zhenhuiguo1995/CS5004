package edu.neu.ccs.cs5004.problem1;

/**
 * Represents details of a parking lot.
 */
public class ParkingLot {

  /**
   * Park a vehicle given the vehicle and a parking spot.
   *
   * @param vehicle the vehicle
   * @param parkingSpot the parking spot
   * @return the boolean
   * @throws UnavailableSpotException the unavailable spot exception
   * @throws InvalidSpotTypeException the invalid spot type exception
   * @throws InvalidSpotSizeException the invalid spot size exception
   */
  public boolean parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot)
      throws UnavailableSpotException, InvalidSpotTypeException, InvalidSpotSizeException {
    try {
      exceptionCheck(vehicle, parkingSpot);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Check if an exception will be thrown.
   *
   * @param vehicle the vehicle
   * @param parkingSpot the parking spot
   * @throws UnavailableSpotException the unavailable spot exception
   * @throws InvalidSpotTypeException the invalid spot type exception
   * @throws InvalidSpotSizeException the invalid spot size exception
   */
  public void exceptionCheck(Vehicle vehicle, ParkingSpot parkingSpot)
      throws UnavailableSpotException, InvalidSpotTypeException, InvalidSpotSizeException {
    unavailableSpotExceptionCheck(vehicle, parkingSpot);
    invalidSpotTypeExceptionCheck(vehicle, parkingSpot);
    invalidSpotSizeExceptionCheck(vehicle, parkingSpot);
  }

  /**
   * Check if an UnavailableSpotException will be thrown.
   *
   * @param vehicle the vehicle
   * @param parkingSpot the parking spot
   * @throws UnavailableSpotException the unavailable spot exception
   */
  public void unavailableSpotExceptionCheck(Vehicle vehicle, ParkingSpot parkingSpot)
      throws UnavailableSpotException {
    if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.TAKEN) {
      throw new UnavailableSpotException();
    }
  }

  /**
   * Check if an InvalidSpotTypeException will be thrown.
   *
   * @param vehicle the vehicle
   * @param parkingSpot the parking spot
   * @throws InvalidSpotTypeException the invalid spot type exception
   */
  public void invalidSpotTypeExceptionCheck(Vehicle vehicle, ParkingSpot parkingSpot)
      throws InvalidSpotTypeException {
    if (parkingSpot.getType() == Type.DISABLE && vehicle.getType() == Type.REGULAR) {
      throw new InvalidSpotTypeException();
    }
  }

  /**
   * Check if an InvalidSpotSizeException will be thrown.
   *
   * @param vehicle the vehicle
   * @param parkingSpot the parking spot
   * @throws InvalidSpotSizeException the invalid spot size exception
   */
  public void invalidSpotSizeExceptionCheck(Vehicle vehicle, ParkingSpot parkingSpot)
      throws InvalidSpotSizeException {
    if ((vehicle.getSize() == Size.LARGE && parkingSpot.getSize() != Size.LARGE)
        || (vehicle.getSize() == Size.MEDIUM && parkingSpot.getSize() == Size.SMALL)) {
      throw new InvalidSpotSizeException();
    }
  }


}
