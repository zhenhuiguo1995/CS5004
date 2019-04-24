package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private String firstName;
  private String lastName;
  private Name name;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Alfred";
    this.lastName = "Stark";
    this.name = new Name(this.firstName, this.lastName);
  }

  @Test
  public void getFirstName() throws Exception {
    assertEquals(this.firstName, this.name.getFirstName());
  }

  @Test
  public void getLastName() throws Exception {
    assertEquals(this.lastName, this.name.getLastName());
  }

}