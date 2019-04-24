package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.omg.CORBA.PUBLIC_MEMBER;

public class ParkingLotTest {
  private Size vehicleSize;
  private Type vehicleType;
  private Vehicle vehicle;
  private ParkingSpotStatus parkingSpotStatus;
  private ParkingSpot parkingSpot;
  private Size parkingSpotSize;
  private Type parkingSpotType;
  private ParkingLot parkingLot;

  @Before
  public void setUp() {
    this.vehicleSize = Size.SMALL;
    this.vehicleType = Type.REGULAR;
    this.parkingSpotSize = Size.LARGE;
    this.parkingSpotStatus = ParkingSpotStatus.AVAILABLE;
    this.parkingSpotType = Type.REGULAR;
    this.vehicle = new Vehicle(vehicleSize, vehicleType);
    this.parkingSpot = new ParkingSpot(parkingSpotSize, parkingSpotStatus, parkingSpotType);
    this.parkingLot = new ParkingLot();
  }

  @Test
  public void parkVehicle() throws Exception {
    assertTrue(this.parkingLot.parkVehicle(this.vehicle, this.parkingSpot));
  }

  @Test
  public void parkingSpotTaken() throws Exception {
    this.parkingSpot = new ParkingSpot(parkingSpotSize, ParkingSpotStatus.TAKEN, parkingSpotType);
    assertFalse(this.parkingLot.parkVehicle(this.vehicle, this.parkingSpot));
  }

  @Test
  public void invalidSpotType() throws Exception {
    this.parkingSpot = new ParkingSpot(parkingSpotSize, ParkingSpotStatus.AVAILABLE, Type.DISABLE);
    assertFalse(this.parkingLot.parkVehicle(this.vehicle, this.parkingSpot));
  }

  @Test
  public void largeVehicleMediumParkingSpot() throws Exception {
    this.vehicle = new Vehicle(Size.LARGE, this.vehicleType);
    this.parkingSpot = new ParkingSpot(Size.MEDIUM, ParkingSpotStatus.AVAILABLE,
        this.parkingSpotType);
    assertFalse(this.parkingLot.parkVehicle(this.vehicle, this.parkingSpot));
  }

  @Test(expected = UnavailableSpotException.class)
  public void exceptionCheckSpotTaken() throws Exception {
    this.parkingSpot = new ParkingSpot(parkingSpotSize, ParkingSpotStatus.TAKEN, parkingSpotType);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }

  @Test(expected = InvalidSpotTypeException.class)
  public void exceptionCheckInvalidType() throws Exception {
    this.parkingSpot = new ParkingSpot(parkingSpotSize, parkingSpotStatus, Type.DISABLE);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }

  @Test(expected = InvalidSpotSizeException.class)
  public void invalidSpotSizeExceptionLargeVehicleMediumParkingSpot() throws Exception {
    this.vehicle = new Vehicle(Size.LARGE, Type.DISABLE);
    this.parkingSpot = new ParkingSpot(Size.MEDIUM, ParkingSpotStatus.AVAILABLE,
        Type.DISABLE);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }

  @Test(expected = InvalidSpotSizeException.class)
  public void exceptionCheckLargeVehicleMediumParkingSpot() throws Exception {
    this.vehicle = new Vehicle(Size.LARGE, this.vehicleType);
    this.parkingSpot = new ParkingSpot(Size.MEDIUM, ParkingSpotStatus.AVAILABLE,
        this.parkingSpotType);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }

  @Test(expected = InvalidSpotSizeException.class)
  public void exceptionCheckMediumVehicleSmallParkingSPot() throws Exception {
    this.vehicle = new Vehicle(Size.MEDIUM, this.vehicleType);
    this.parkingSpot = new ParkingSpot(Size.SMALL, ParkingSpotStatus.AVAILABLE,
        this.parkingSpotType);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }

  @Test
  public void exceptionCheckLargeVehicleLargeParkingSpot()
      throws InvalidSpotTypeException, InvalidSpotSizeException, UnavailableSpotException {
    this.vehicle = new Vehicle(Size.LARGE, this.vehicleType);
    this.parkingSpot = new ParkingSpot(Size.LARGE, ParkingSpotStatus.AVAILABLE,
        this.parkingSpotType);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }

  @Test
  public void exceptionCheckMediumVehicleMediumParkingSpot()
      throws InvalidSpotTypeException, InvalidSpotSizeException, UnavailableSpotException {
    this.vehicle = new Vehicle(Size.MEDIUM, this.vehicleType);
    this.parkingSpot = new ParkingSpot(Size.MEDIUM, ParkingSpotStatus.AVAILABLE,
        this.parkingSpotType);
    this.parkingLot.exceptionCheck(this.vehicle, this.parkingSpot);
  }


}