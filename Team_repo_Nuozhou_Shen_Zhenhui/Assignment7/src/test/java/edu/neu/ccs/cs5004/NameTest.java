package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name testName;

  @org.junit.Before
  public void setUp() throws Exception {
    testName = new Name("Alice", "Green");
  }

  @org.junit.Test
  public void getFirstName() {
    assertEquals("Alice", this.testName.getFirstName());
  }

  @org.junit.Test
  public void getLastName() {
    assertEquals("Green", this.testName.getLastName());
  }
}