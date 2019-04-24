package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

  private LocalDate driverBirthday;
  private LocalDate driverBirthday2;
  private List<MovingViolation> movingList;
  private List<NonMovingViolation> nonMovingList;
  private List<NonMovingViolation> nonMovingList2;
  private Name testName;
  private Name testName2;
  private LocalDate testDate;
  private MovingViolation testViolation;
  private NonMovingViolation testViolation3;
  private NonMovingViolation testViolation4;
  private DriverHistory history1;
  private DriverHistory history2;
  private Driver testDriver;
  private Driver testDriver2;
  private Driver testDriver3;
  private Driver testDriver4;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice", "Green");
    testName2 = new Name("Bob", "Clinton");
    testDate = LocalDate.of(2018, 2, 3);
    driverBirthday = LocalDate.of(1980, 2, 3);
    driverBirthday2 = LocalDate.of(1990, 10, 3);
    testViolation = new MovingViolation(testName, testDate, MovingViolationReason.DistractedDriving);
    testViolation3 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.ParkingViolation);
    testViolation4 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.PaperworkIssues);
    movingList = new ArrayList<>();
    nonMovingList = new ArrayList<>();
    nonMovingList2 = new ArrayList<>();
    movingList.add(testViolation);
    nonMovingList.add(testViolation3);
    nonMovingList2.add(testViolation4);
    history1 = new DriverHistory(movingList, nonMovingList);
    history2 = new DriverHistory(movingList, nonMovingList2);
    testDriver = new Driver(testName, driverBirthday, history1);
    testDriver2 = new Driver(testName2, driverBirthday, history1);
    testDriver3 = new Driver(testName, driverBirthday2, history1);
    testDriver4 = new Driver(testName, driverBirthday, history2);


  }

  @Test
  public void getHistory() {
    assertEquals(history1, testDriver.getHistory());
  }

  @Test
  public void testToString() {
    assertEquals("Driver{history=DriverHistory{movingAbstractViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-02-03, violation=DistractedDriving}], nonMovingAbstractViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=2018-02-03, violation=ParkingViolation}]}}"
        ,testDriver.toString());
  }

  @Test
  public void equals() {
    assertTrue(testDriver.equals(testDriver));
    assertFalse(testDriver.equals(null));
    assertFalse(testDriver.equals(testDriver2));
    assertFalse(testDriver.equals(testDriver3));
    assertFalse(testDriver.equals(testDriver4));
    assertFalse(testDriver.equals("TEST"));
  }

  @Test
  public void testHashCode() {
    assertEquals(testDriver.hashCode(), testDriver.hashCode());
    assertNotEquals(testDriver.hashCode(), testDriver2.hashCode());
  }
}