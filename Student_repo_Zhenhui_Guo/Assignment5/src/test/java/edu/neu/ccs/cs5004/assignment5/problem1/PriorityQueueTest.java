package edu.neu.ccs.cs5004.assignment5.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
  private ListNode head;
  private PriorityQueue pq;
  private Element element;
  private String string;
  private Integer integer;

  @Before
  public void setUp() throws Exception {
    this.string = "hello world";
    this.integer = 9;
    this.element = new Element(this.string, this.integer);
    this.head = new ListNode(element, null);
    this.pq = new PriorityQueue(this.head);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() throws IllegalArgumentException {
    this.head = null;
    this.pq = new PriorityQueue(this.head);
  }

  @Test
  public void createEmpty() throws Exception {
    EmptyPriorityQueue i = (EmptyPriorityQueue) this.pq.createEmpty();
    assertNull(i.getHead());
  }

  @Test
  public void add() throws Exception {
    String s = "OOD";
    Integer i = 3;
    Element e = new Element(s, i);
    this.pq = (PriorityQueue) this.pq.add(i, s);
    assertEquals(this.element, this.pq.getHead().getNode());
    assertEquals(e, this.pq.getHead().getNext().getNode());
  }

  @Test
  public void peek() throws Exception {
    assertEquals(this.string, this.pq.getHead().getNode().getString());
  }

  @Test
  public void pop() throws Exception {
    EmptyPriorityQueue i = (EmptyPriorityQueue) this.pq.pop();
    assertNull(i.getHead());
  }

  @Test
  public void popTwo() throws Exception {
    this.pq = (PriorityQueue) this.pq.add(8, "domain");
    this.pq = (PriorityQueue) this.pq.pop();
    assertEquals(this.pq.getHead().getNode(), new Element("domain", 8));
  }


  @Test
  public void isEmpty() throws Exception {
    assertFalse(this.pq.isEmpty());
  }

  @Test
  public void equalsItself() {
    assertTrue(this.pq.equals(this.pq));
  }

  @Test
  public void notEqualsNull() {
    assertFalse(this.pq.equals(null));
  }

  @Test
  public void notEqualsDifferentClass() {
    assertFalse(this.pq.equals(new Element("admin", 8)));
  }




/*
  @Test
  public String toString()  {
    return "Hello World";
  }*/


/*
  @Test
  public void hashCode() throws Exception {
  }*/

}