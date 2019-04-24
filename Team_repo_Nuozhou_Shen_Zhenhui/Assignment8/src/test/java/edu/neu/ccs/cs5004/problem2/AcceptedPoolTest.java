package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class AcceptedPoolTest {

  private AcceptedPool pool;
  private AcceptedPool pool2;
  private List<Vehicle> list;
  private LocalDate driverBirthday;
  private LocalDate driverBirthday2;
  private List<MovingViolation> movingList;
  private List<NonMovingViolation> nonMovingList;
  private Name testName;
  private Name testName2;
  private LocalDate testDate;
  private MovingViolation testViolation;
  private NonMovingViolation testViolation2;
  private DriverHistory history;
  private Driver testDriver;
  private Driver testDriver2;

  private LocalDate testDate2;
  private Person owner;
  private List<Crash> crashList;
  private Crash testCrash;
  private VehicleHistory history2;
  private Vehicle vehicle1;
  private Vehicle vehicle2;
  private Map<Driver, List<Vehicle>> map;


  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice", "Green");
    testName2 = new Name("Bob", "Clinton");
    testDate = LocalDate.of(2018, 2, 3);
    driverBirthday = LocalDate.of(1980, 2, 3);
    driverBirthday2 = LocalDate.of(1990, 10, 3);
    testViolation = new MovingViolation(testName, testDate, MovingViolationReason.DistractedDriving);
    testViolation2 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.ParkingViolation);
    movingList = new ArrayList<>();
    nonMovingList = new ArrayList<>();
    movingList.add(testViolation);
    nonMovingList.add(testViolation2);
    history = new DriverHistory(movingList, nonMovingList);
    testDriver = new Driver(testName, driverBirthday, history);
    testDriver2 = new Driver(testName2, driverBirthday2, history);

    testDate2 = LocalDate.of(2018, 12, 3);
    owner = new Person(testName, driverBirthday);
    testCrash = new Crash(testDate2, CrashReason.CrashWithBodilyInjuries);
    crashList = new ArrayList<>();
    crashList.add(testCrash);
    history2 = new VehicleHistory(movingList, nonMovingList, crashList);
    vehicle1 = new Vehicle("Honda", "CRV", 2010, owner, history2);
    vehicle2 = new Vehicle("Toyota", "CRV", 2010, owner, history2);
    list = new ArrayList<>();
    list.add(vehicle1);
    map = new HashMap<>();
    map.put(testDriver, list);
    pool = new AcceptedPool();
    pool2 = new AcceptedPool(map);

  }


  @Test
  public void getPool() {
    assertEquals(map, pool2.getPool());
  }

  @Test
  public void addDriver() {
    assertTrue(pool.addDriver(testDriver, vehicle1));
    assertFalse(pool.addDriver(testDriver, vehicle1));
    assertTrue(pool.addDriver(testDriver2, vehicle1));
    assertTrue(pool.addDriver(testDriver, vehicle2));
  }

  @Test
  public void testToString() {
    assertEquals(
        "AcceptedPool{pool={Driver{history=DriverHistory{movingAbstractViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-02-03, violation=DistractedDriving}], nonMovingAbstractViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-02-03, violation=ParkingViolation}]}}=[Vehicle{make='Honda', model='CRV', year=2010, owner=Person{name=Name{firstName='Alice', lastName='Green'}, birthday=1980-02-03}, vehicleHistory=VehicleHistory{movingViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-02-03, violation=DistractedDriving}], nonMovingViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-02-03, violation=ParkingViolation}], crashList=[Crash{date=2018-12-03, crashReason=CrashWithBodilyInjuries}]}}]}}",
        pool2.toString());
  }

  @Test
  public void equals() {
    assertTrue(pool2.equals(pool2));
    assertFalse(pool2.equals(null));
    assertFalse(pool2.equals("TEST"));
    assertFalse(pool2.equals(pool));
    pool.addDriver(testDriver, vehicle1);
    assertTrue(pool2.equals(pool));
    pool.addDriver(testDriver, vehicle2);
    assertFalse(pool2.equals(pool));
    pool2.addDriver(testDriver, vehicle2);
    pool.addDriver(testDriver2, vehicle1);
    assertFalse(pool2.equals(pool));

  }

  @Test
  public void testHashCode() {
    assertEquals(pool2.hashCode(), pool2.hashCode());
    assertNotEquals(pool2.hashCode(), pool.hashCode());
  }

}