package edu.neu.ccs.cs5004.listOfIntegers;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {

  private List empty;
  private List oneElement;
  private List twoElements;
  private List threeElements;

  @org.junit.Before
  public void setUp() throws Exception {
    this.empty = new Empty();
    this.oneElement = new Cons(10, this.empty);
    this.twoElements = new Cons(20, this.oneElement);
    this.threeElements = new Cons(30, this.twoElements);
  }

  @Test
  public void size() throws Exception {
    Assert.assertEquals(this.empty.size(), new Integer(0));
    Assert.assertEquals(this.oneElement.size(), new Integer(1));
    Assert.assertEquals(this.twoElements.size(), new Integer(2));
    Assert.assertEquals(this.threeElements.size(), new Integer(3));
  }

  @Test
  public void testLast() throws Exception {
    Assert.assertEquals(this.threeElements.last(), new Integer(10));
  }

  @Test(expected= InvalidCallException.class)
  public void testLastOnEmpty() throws Exception {
    this.empty.last();
  }

  @Test(expected = InvalidCallException.class)
  public void testLastOnEmptyWithNoTry() throws Exception {
    this.empty.last();
  }


}
