package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class CrashTest {

  private Crash testCrash;
  private LocalDate testDate;
  private LocalDate testDate2;
  private Crash testCrash2;
  private Crash testCrash3;
  private Crash testCrash4;

  @Before
  public void setUp() throws Exception {
    this.testDate = LocalDate.of(1980, 2, 3);
    this.testDate = LocalDate.of(1950, 2, 3);
    testCrash = new Crash(testDate, CrashReason.CrashWithBodilyInjuries);
    testCrash2 = new Crash(testDate, CrashReason.CrashWithBodilyInjuries);
    testCrash3 = new Crash(testDate, CrashReason.CrashWithoutBodilyInjuries);
    testCrash4 = new Crash(testDate2, CrashReason.CrashWithBodilyInjuries);
  }

  @Test
  public void getDate() {
    assertEquals(testDate, testCrash.getDate());
  }

  @Test
  public void getCrashReason() {
    assertEquals(CrashReason.CrashWithBodilyInjuries, this.testCrash.getCrashReason());
  }

  @Test
  public void testToString() {
    assertEquals("Crash{date=1950-02-03, crashReason=CrashWithBodilyInjuries}",
        this.testCrash.toString());
  }

  @Test
  public void equals() {
    assertTrue(testCrash.equals(testCrash));
    assertFalse(testCrash.equals(null));
    assertFalse(testCrash.equals("TEST"));
    assertTrue(testCrash.equals(testCrash2));
    assertFalse(testCrash.equals(testCrash3));
    assertFalse(testCrash.equals(testCrash4));
  }

  @Test
  public void testHashCode() {
    assertEquals(testCrash.hashCode(), testCrash2.hashCode());
    assertNotEquals(testCrash.hashCode(), testCrash3.hashCode());
    assertNotEquals(testCrash.hashCode(), testCrash4.hashCode());
  }
}