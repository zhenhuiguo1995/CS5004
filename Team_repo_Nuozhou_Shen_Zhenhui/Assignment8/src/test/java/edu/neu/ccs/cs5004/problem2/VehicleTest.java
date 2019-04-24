package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  private Name testName;
  private LocalDate testDate;
  private LocalDate testDate2;
  private Person owner;
  private Person owner2;
  private List<MovingViolation> movingList;
  private List<MovingViolation> movingList2;
  private List<NonMovingViolation> nonMovingList;
  private List<Crash> crashList;
  private LocalDate testDate3;
  private MovingViolation testViolation;
  private MovingViolation testViolation2;
  private NonMovingViolation testViolation3;
  private Crash testCrash;
  private VehicleHistory history1;
  private VehicleHistory history2;
  private Vehicle vehicle;
  private Vehicle vehicle2;
  private Vehicle vehicle3;
  private Vehicle vehicle4;
  private Vehicle vehicle5;
  private Vehicle vehicle6;
  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice","Green");
    testDate = LocalDate.of(1998,2,3);
    testDate2 = LocalDate.of(1980,7,23);
    owner = new Person(testName,testDate);
    owner2 = new Person(testName,testDate2);
    movingList = new ArrayList<>();
    movingList2 = new ArrayList<>();
    nonMovingList = new ArrayList<>();
    testDate3 = LocalDate.of(2018,12,30);
    testViolation = new MovingViolation(testName,testDate3,MovingViolationReason.DistractedDriving);
    testViolation2 = new MovingViolation(testName,testDate3,MovingViolationReason.FailureToRespectTrafficSigns);
    testViolation3 = new NonMovingViolation(testName,testDate3,NonMovingViolationReason.ParkingViolation);
    movingList.add(testViolation);
    movingList2.add(testViolation2);
    nonMovingList.add(testViolation3);
    testCrash = new Crash(testDate3,CrashReason.CrashWithBodilyInjuries);
    crashList = new ArrayList<>();
    crashList.add(testCrash);
    history1 = new VehicleHistory(movingList,nonMovingList,crashList);
    history2 = new VehicleHistory(movingList2,nonMovingList,crashList);
    vehicle = new Vehicle("Honda","CRV",2010,owner,history1);
    vehicle2 = new Vehicle("Toyota","CRV",2010,owner,history1);
    vehicle3 = new Vehicle("Honda","Accord",2010,owner,history1);
    vehicle4 = new Vehicle("Honda","CRV",2016,owner,history1);
    vehicle5 = new Vehicle("Honda","CRV",2010,owner2,history1);
    vehicle6 = new Vehicle("Honda","CRV",2010,owner,history2);

  }

  @Test
  public void getYear() {
    assertEquals(2010,vehicle.getYear());
  }

  @Test
  public void getOwner() {
    assertEquals(owner,vehicle.getOwner());
  }

  @Test
  public void getVehicleHistory() {
    assertEquals(history1,vehicle.getVehicleHistory());
  }

  @Test
  public void testToString() {
    assertEquals("Vehicle{make='Honda', model='CRV', year=2010, owner=Person{name=Name{firstName='Alice', lastName='Green'}, birthday=1998-02-03}, vehicleHistory=VehicleHistory{movingViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-12-30, violation=DistractedDriving}], nonMovingViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-12-30, violation=ParkingViolation}], crashList=[Crash{date=2018-12-30, crashReason=CrashWithBodilyInjuries}]}}",vehicle.toString());
  }

  @Test
  public void equals() {
    assertTrue(vehicle.equals(vehicle));
    assertFalse(vehicle.equals(null));
    assertFalse(vehicle.equals("TEST"));
    assertFalse(vehicle.equals(vehicle2));
    assertFalse(vehicle.equals(vehicle3));
    assertFalse(vehicle.equals(vehicle4));
    assertFalse(vehicle.equals(vehicle5));
    assertFalse(vehicle.equals(vehicle6));
  }

  @Test
  public void testHashCode() {
    assertEquals(vehicle.hashCode(),vehicle.hashCode());
    assertNotEquals(vehicle.hashCode(),vehicle2.hashCode());
  }
}