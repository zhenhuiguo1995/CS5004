package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {

  private List<MovingViolation> movingList;
  private List<MovingViolation> movingList2;
  private List<NonMovingViolation> nonMovingList;
  private List<NonMovingViolation> nonMovingList2;
  private List<Crash> crashList;
  private List<Crash> crashList2;
  private Name testName;
  private LocalDate testDate;
  private MovingViolation testViolation;
  private MovingViolation testViolation2;
  private NonMovingViolation testViolation3;
  private NonMovingViolation testViolation4;
  private Crash testCrash;
  private Crash testCrash2;
  private VehicleHistory history1;
  private VehicleHistory history2;
  private VehicleHistory history3;
  private VehicleHistory history4;

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
    testCrash = new Crash(testDate, CrashReason.CrashWithBodilyInjuries);
    testCrash2 = new Crash(testDate, CrashReason.CrashWithoutBodilyInjuries);
    crashList = new ArrayList<>();
    crashList2 = new ArrayList<>();
    crashList.add(testCrash);
    crashList2.add(testCrash2);
    history1 = new VehicleHistory(movingList, nonMovingList, crashList);
    history2 = new VehicleHistory(movingList2, nonMovingList, crashList);
    history3 = new VehicleHistory(movingList, nonMovingList2, crashList);
    history4 = new VehicleHistory(movingList, nonMovingList, crashList2);
  }

  @Test
  public void getMovingViolationList() {
    assertEquals(movingList, history1.getMovingViolationList());
  }

  @Test
  public void getCrashList() {
    assertEquals(crashList, history1.getCrashList());
  }

  @Test
  public void testToString() {
    assertEquals(
        "VehicleHistory{movingViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=DistractedDriving}], nonMovingViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=ParkingViolation}], crashList=[Crash{date=1980-02-03, crashReason=CrashWithBodilyInjuries}]}",history1.toString());
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