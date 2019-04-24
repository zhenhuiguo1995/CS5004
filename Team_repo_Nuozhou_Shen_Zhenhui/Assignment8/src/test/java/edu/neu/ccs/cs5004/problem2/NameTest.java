package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name testName;
  private Name testName2;
  private Name testName3;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice","Green");
    testName2 = new Name("Alice","Clinton");
    testName3 = new Name("Emma","Clinton");

  }

  @Test
  public void getFirstName() {
    assertEquals("Alice",this.testName.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Green",this.testName.getLastName());
  }

  @Test
  public void testToString() {
    assertEquals("Name{firstName='Alice', lastName='Green'}",this.testName.toString());
  }

  @Test
  public void equals() {
    assertTrue(testName.equals(testName));
    assertFalse(testName.equals(null));
    assertFalse(testName.equals("TEST"));
    assertFalse(testName.equals(testName2));
    assertFalse(testName.equals(testName3));
  }

  @Test
  public void testHashCode() {
    assertEquals(testName.hashCode(),testName.hashCode());
    assertNotEquals(testName.hashCode(),testName2.hashCode());
    assertNotEquals(testName.hashCode(),testName3.hashCode());
  }
}