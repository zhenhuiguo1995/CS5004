package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class NonMovingViolationTest {

  private Name testName;
  private LocalDate testDate;
  private NonMovingViolation testViolation;
  private LocalDate testDate2;
  private NonMovingViolation testViolation2;
  private Name testName2;
  private NonMovingViolation testViolation3;
  private NonMovingViolation testViolation4;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice", "Green");
    testDate = LocalDate.of(1980, 2, 3);
    testViolation = new NonMovingViolation(testName, testDate, NonMovingViolationReason.ParkingViolation);
    testViolation2 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.PaperworkIssues);
    testDate2 = LocalDate.of(1960, 10, 2);
    testName2 = new Name("Bob", "Green");
    testViolation3 = new NonMovingViolation(testName, testDate2, NonMovingViolationReason.ParkingViolation);
    testViolation4 = new NonMovingViolation(testName2, testDate, NonMovingViolationReason.PaperworkIssues);

  }


  @Test
  public void getViolation() {
    assertEquals(NonMovingViolationReason.ParkingViolation, this.testViolation.getViolation());
  }

  @Test
  public void getDate() {
    assertEquals(testDate, testViolation.getDate());

  }

  @Test
  public void testToString() {
    assertEquals(
        "NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=ParkingViolation}",this.testViolation.toString());
  }

  @Test
  public void equals() {
    assertTrue(testViolation.equals(testViolation));
    assertFalse(testViolation.equals(null));
    assertFalse(testViolation.equals(testViolation2));
    assertFalse(testViolation.equals(testViolation3));
    assertFalse(testViolation.equals(testViolation4));
  }

  @Test
  public void testHashCode() {
    assertEquals(testViolation.hashCode(), testViolation.hashCode());
    assertNotEquals(testViolation.hashCode(), testViolation2.hashCode());
  }
}