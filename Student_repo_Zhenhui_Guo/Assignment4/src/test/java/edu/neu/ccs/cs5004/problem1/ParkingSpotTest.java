package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingSpotTest {
  private Size size;
  private ParkingSpotStatus parkingSpotStatus;
  private Type type;
  private ParkingSpot parkingSpot;

  @Before
  public void setUp() throws Exception {
    this.size = Size.SMALL;
    this.type = Type.REGULAR;
    this.parkingSpotStatus = ParkingSpotStatus.AVAILABLE;
    this.parkingSpot = new ParkingSpot(this.size, this.parkingSpotStatus, this.type);
  }

  @Test
  public void getParkingSpotSize() throws Exception {
    assertEquals(this.size, this.parkingSpot.getSize());
  }

  @Test
  public void getParkingSpotStatus() throws Exception {
    assertEquals(this.parkingSpotStatus, this.parkingSpot.getParkingSpotStatus());
  }

  @Test
  public void getParkingSpotType() throws Exception {
    assertEquals(this.type, this.parkingSpot.getType());
  }

}