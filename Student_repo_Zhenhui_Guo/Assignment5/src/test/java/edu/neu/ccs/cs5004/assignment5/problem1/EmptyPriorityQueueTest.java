package edu.neu.ccs.cs5004.assignment5.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyPriorityQueueTest {
  private EmptyPriorityQueue emptyPriorityQueue;

  @Before
  public void setUp() throws Exception {
    this.emptyPriorityQueue = new EmptyPriorityQueue();
  }

  @Test
  public void createEmpty() throws Exception {
    EmptyPriorityQueue p = (EmptyPriorityQueue) emptyPriorityQueue.createEmpty();
    assertNull(p.getHead());
  }

  @Test
  public void add() throws Exception {
    IPriorityQueue pq =  this.emptyPriorityQueue.add(10, "Hello World");
    assertEquals("Hello World" ,pq.peek());
  }

  @Test(expected = IndexOutOfRangeException.class)
  public void peek() throws Exception {
    this.emptyPriorityQueue.peek();
  }

  @Test(expected = IndexOutOfRangeException.class)
  public void pop() throws Exception {
    this.emptyPriorityQueue.pop();
  }

  @Test
  public void isEmpty() throws Exception {
    assertTrue(this.emptyPriorityQueue.isEmpty());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.emptyPriorityQueue.equals(this.emptyPriorityQueue));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.emptyPriorityQueue.equals(null));
  }

  @Test
  public void notEqualsDifferentClass() throws Exception {
    assertFalse(this.emptyPriorityQueue.equals(new Element(null, null)));
  }

  @Test
  public void equalsOther() throws Exception {
    assertTrue(this.emptyPriorityQueue.equals(new EmptyPriorityQueue()));
  }

}