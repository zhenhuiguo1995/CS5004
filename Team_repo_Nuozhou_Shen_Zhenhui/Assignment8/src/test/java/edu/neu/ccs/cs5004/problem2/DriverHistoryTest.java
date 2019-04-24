package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {

  private List<MovingViolation> movingList;
  private List<MovingViolation> movingList2;
  private List<NonMovingViolation> nonMovingList;
  private List<NonMovingViolation> nonMovingList2;
  private Name testName;
  private LocalDate testDate;
  private MovingViolation testViolation;
  private MovingViolation testViolation2;
  private NonMovingViolation testViolation3;
  private NonMovingViolation testViolation4;
  private DriverHistory history1;
  private DriverHistory history2;
  private DriverHistory history3;
  private DriverHistory history4;

  @Before
  public void setUp() throws Exception {
    movingList = new ArrayList<>();
    movingList2 = new ArrayList<>();
    nonMovingList = new ArrayList<>();
    nonMovingList2 = new ArrayList<>();
    testName = new Name("Alice", "Green");
    testDate = LocalDate.of(1980, 2, 3);
    testViolation = new MovingViolation(testName, testDate, MovingViolationReason.DistractedDriving);
    testViolation2 = new MovingViolation(testName, testDate,
        MovingViolationReason.FailureToRespectTrafficSigns);
    testViolation3 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.ParkingViolation);
    testViolation4 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.PaperworkIssues);
    movingList.add(testViolation);
    movingList2.add(testViolation2);
    nonMovingList.add(testViolation3);
    nonMovingList2.add(testViolation4);
    history1 = new DriverHistory(movingList, nonMovingList);
    history2 = new DriverHistory(movingList, nonMovingList2);
    history3 = new DriverHistory(movingList2, nonMovingList);
    history4 = new DriverHistory(movingList2, nonMovingList2);

  }

  @Test
  public void getMovingViolationList() {
    assertEquals(movingList, history1.getMovingViolationList());
  }

  @Test
  public void getNonMovingAbstractViolationList() {
    assertEquals(nonMovingList, history1.getNonMovingAbstractViolationList());
  }

  @Test
  public void testToString() {
    assertEquals(
        "DriverHistory{movingAbstractViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=DistractedDriving}], nonMovingAbstractViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=ParkingViolation}]}",this.history1.toString());
  }

  @Test
  public void equals() {
    assertTrue(history1.equals(history1));
    assertFalse(history1.equals(null));
    assertFalse(history1.equals("TEST"));
    assertFalse(history1.equals(history2));
    assertFalse(history1.equals(history3));
    assertFalse(history1.equals(history4));
  }

  @Test
  public void testHashCode() {
    assertEquals(history1.hashCode(), history1.hashCode());
    assertNotEquals(history1.hashCode(), history2.hashCode());
  }
}