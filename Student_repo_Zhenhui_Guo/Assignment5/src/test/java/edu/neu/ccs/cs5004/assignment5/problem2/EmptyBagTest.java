package edu.neu.ccs.cs5004.assignment5.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyBagTest {
  private EmptyBag emptyBag;

  @Before
  public void setUp() throws Exception {
    this.emptyBag = new EmptyBag();
  }


  @Test
  public void size() throws Exception {
    assertSame(0, this.emptyBag.size());
  }

  @Test
  public void add() throws Exception {
  }

  @Test
  public void contains() throws Exception {
    assertFalse(this.emptyBag.contains("a"));
  }

  @Test
  public void equals() throws Exception {
    assertTrue(this.emptyBag.equals(this.emptyBag));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.emptyBag.equals(null));
  }

  @Test
  public void notEqualsDifferentClass() throws Exception {
    assertFalse(this.emptyBag.equals(new ListNode(null, null)));
  }

  @Test
  public void equalsAnotherEmptyBag() throws Exception {
    assertTrue(this.emptyBag.equals(new EmptyBag()));
  }

}