package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class MovingViolationTest {
  private Name testName;
  private LocalDate testDate;
  private MovingViolation testViolation;
  private LocalDate testDate2;
  private MovingViolation testViolation2;
  private Name testName2;
  private MovingViolation testViolation3;
  private MovingViolation testViolation4;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice","Green");
    testDate = LocalDate.of(1980,2,3);
    testViolation = new MovingViolation(testName,testDate,MovingViolationReason.DistractedDriving);
    testViolation2 = new MovingViolation(testName,testDate,MovingViolationReason.FailureToRespectTrafficSigns);
    testDate2 = LocalDate.of(1960,10,2);
    testName2 = new Name("Bob","Green");
    testViolation3 = new MovingViolation(testName,testDate2,MovingViolationReason.DistractedDriving);
    testViolation4 = new MovingViolation(testName2,testDate,MovingViolationReason.DistractedDriving);

  }

  @Test
  public void getViolation() {
    assertEquals(MovingViolationReason.DistractedDriving,this.testViolation.getViolation());
  }

  @Test
  public void getDate() {
    assertEquals(testDate,testViolation.getDate());

  }

  @Test
  public void testToString() {
    assertEquals("MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=DistractedDriving}",this.testViolation.toString());
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
    assertEquals(testViolation.hashCode(),testViolation.hashCode());
    assertNotEquals(testViolation.hashCode(),testViolation2.hashCode());
  }
}