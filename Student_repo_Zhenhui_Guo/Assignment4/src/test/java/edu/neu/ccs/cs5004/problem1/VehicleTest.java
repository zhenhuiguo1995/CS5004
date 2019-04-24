package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  private Size size;
  private Type type;
  private Vehicle vehicle;

  @Before
  public void setUp() throws Exception {
    this.size = Size.MEDIUM;
    this.type = Type.REGULAR;
    this.vehicle = new Vehicle(this.size, this.type);
  }

  @Test
  public void getVehicleSize() {
    assertEquals(this.size, this.vehicle.getSize());

  }

  @Test
  public void getVehicleType() {
    assertEquals(this.type, this.vehicle.getType());
  }

}