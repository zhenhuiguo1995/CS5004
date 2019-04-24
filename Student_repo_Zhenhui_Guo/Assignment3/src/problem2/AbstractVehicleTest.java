package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractVehicleTest {
  private final int MAX_VELOCITY = 60;
  private String color;
  private String make;
  private String model;
  private MakeAndModel makeAndModel;
  private double velocity;
  private DIRECTION direction;
  private AbstractVehicle vehicle;
  private int accelerationFactor;
  private int decelerateFactor;

  @Before
  public void setUp() throws Exception {
    this.color = "blue";
    this.make = "Audi";
    this.model = "A4 Sedan";
    this.makeAndModel = new MakeAndModel(this.make, this.model);
    this.velocity = 50;
    this.direction = DIRECTION.EASTBOUND;
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, this.direction);
}

  @Test(expected = IllegalArgumentException.class)
  public void SpeedTooSmall() throws Exception {
    this.velocity = 30;
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, this.direction);
  }

  @Test(expected = IllegalArgumentException.class)
  public void SpeedTooLarge() throws Exception {
    this.velocity = 65;
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, this.direction);
  }


  @Test
  public void createNewDirection() throws Exception {
    this.vehicle = this.vehicle.create(this.velocity, DIRECTION.WESTBOUND);
    assertEquals(DIRECTION.WESTBOUND, this.vehicle.getDirection());
    assertEquals(this.color, this.vehicle.getColor());
    assertEquals(this.makeAndModel, this.vehicle.getMakeAndModel());
    assertEquals(this.velocity, this.vehicle.getVelocity(), 0);
  }

  @Test
  public void createNewVelocity() throws Exception {
    double velocity = 55;
    this.vehicle = this.vehicle.create(velocity, this.direction);
    assertEquals(velocity, this.vehicle.getVelocity(),0);
    assertEquals(this.color, this.vehicle.getColor());
    assertEquals(this.makeAndModel, this.vehicle.getMakeAndModel());
    assertEquals(this.direction, this.vehicle.getDirection());
  }

  @Test
  public void accelerate() throws Exception {
    this.accelerationFactor = 10;
    double expected = this.vehicle.getVelocity() * (1 + (double) this.accelerationFactor/100);
    this.vehicle = this.vehicle.accelerate(this.accelerationFactor);
    assertEquals(expected, this.vehicle.getVelocity(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void accelerationFactorTooSmall() throws Exception {
    this.accelerationFactor = 9;
    this.vehicle = this.vehicle.accelerate(this.accelerationFactor);
  }

  @Test(expected = IllegalArgumentException.class)
  public void accelerationFactorTooLarge() throws Exception {
    this.accelerationFactor = 51;
    this.vehicle = this.vehicle.accelerate(this.accelerationFactor);
  }

  @Test(expected = InvalidAccelerationException.class)
  public void invalidAcceleration() throws Exception {
    this.accelerationFactor = 30;
    this.vehicle.accelerate(this.accelerationFactor);
  }

  @Test
  public void decelerate() throws Exception {
    this.decelerateFactor = 20;
    double expected = this.vehicle.getVelocity() * (1 - this.decelerateFactor/100);
    assertEquals(expected, this.vehicle.getVelocity(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void decelerationFactorTooSmall() throws Exception {
    this.decelerateFactor = 19;
    this.vehicle.decelerate(this.decelerateFactor);
  }

  @Test(expected = IllegalArgumentException.class)
  public void decelerationFactorTooLarge() throws Exception {
    this.decelerateFactor = 51;
    this.vehicle.decelerate(this.decelerateFactor);
  }

  @Test(expected = InvalidDecelerationException.class)
  public void invalidDeceleration() throws Exception {
    this.decelerateFactor = 21;
    this.vehicle.decelerate(this.decelerateFactor);
  }

  @Test
  public void EastToWest() throws Exception {
    this.vehicle = this.vehicle.directionChange(DIRECTION.WESTBOUND);
    assertEquals(DIRECTION.WESTBOUND, this.vehicle.getDirection());
  }

  @Test(expected = InvalidDirectionException.class)
  public void EastToSouth() throws Exception {
    this.vehicle = this.vehicle.directionChange(DIRECTION.SOUTHBOUND);
  }

  @Test(expected = InvalidDirectionException.class)
  public void EastToNorth() throws Exception {
    this.vehicle = this.vehicle.directionChange(DIRECTION.NORTHBOUND);
  }

  @Test
  public void WestToEast() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.WESTBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.EASTBOUND);
    assertEquals(DIRECTION.EASTBOUND, this.vehicle.getDirection());
  }

  @Test(expected = InvalidDirectionException.class)
  public void WestToSouth() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.WESTBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.SOUTHBOUND);
  }

  @Test(expected = InvalidDirectionException.class)
  public void WestToNorth() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.WESTBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.NORTHBOUND);
  }

  @Test
  public void SouthToNorth() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.SOUTHBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.NORTHBOUND);
    assertEquals(DIRECTION.NORTHBOUND, this.vehicle.getDirection());
  }

  @Test(expected = InvalidDirectionException.class)
  public void SouthToEast() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.SOUTHBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.EASTBOUND);
  }

  @Test(expected = InvalidDirectionException.class)
  public void SouthToWest() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.WESTBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.WESTBOUND);
  }

  @Test
  public void NorthToSouth() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.NORTHBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.SOUTHBOUND);
    assertEquals(DIRECTION.SOUTHBOUND, this.vehicle.getDirection());
  }

  @Test(expected = InvalidDirectionException.class)
  public void NorthToEast() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.NORTHBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.EASTBOUND);
  }

  @Test(expected = InvalidDirectionException.class)
  public void NorthToWest() throws Exception {
    this.vehicle = new Bus(this.color, this.makeAndModel, this.velocity, DIRECTION.NORTHBOUND);
    this.vehicle = this.vehicle.directionChange(DIRECTION.WESTBOUND);
  }



  @Test
  public void getColor() throws Exception {
    assertEquals(this.color, this.vehicle.getColor());
  }

  @Test
  public void getMakeAndModel() throws Exception {
    assertEquals(this.makeAndModel, this.vehicle.getMakeAndModel());
  }

  @Test
  public void getVelocity() throws Exception {
    assertEquals(this.velocity, this.vehicle.getVelocity(), 0);
  }

  @Test
  public void getDirection() throws Exception {
    assertEquals(this.direction, this.vehicle.getDirection());
  }

  @Test
  public void getMaxVelocity() throws Exception {
    assertEquals(MAX_VELOCITY, this.vehicle.getMaxVelocity());
  }

}