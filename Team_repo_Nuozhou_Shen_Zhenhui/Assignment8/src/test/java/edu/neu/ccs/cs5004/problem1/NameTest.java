package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private static final String TEST_FIRST_NAME = "Harry";
  private static final String TEST_LAST_NAME = "Potter";
  private Name testName;
  private Name testName2;

  @Before
  public void setUp() {
    testName = new Name(TEST_FIRST_NAME, TEST_LAST_NAME);
    testName2 = new Name(TEST_FIRST_NAME, TEST_LAST_NAME);
  }

  @Test
  public void testGetFirstName() {
    assertEquals(TEST_FIRST_NAME, testName.getFirstName());
  }

  @Test
  public void testGetLastName() {
    assertEquals(TEST_LAST_NAME, testName.getLastName());
  }

  @Test
  public void testEquals() {
    assertEquals(testName, testName);
    assertFalse(testName.equals(null));
    assertFalse(testName.equals(TEST_FIRST_NAME));
    assertTrue(testName.equals(testName2));
  }

  @Test
  public void testToString() {
    assertEquals("Harry Potter", testName.toString());
  }
}