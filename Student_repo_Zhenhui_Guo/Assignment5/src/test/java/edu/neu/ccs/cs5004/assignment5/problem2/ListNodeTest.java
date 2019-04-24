package edu.neu.ccs.cs5004.assignment5.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListNodeTest {
  private String first;
  private ListNode next;
  private ListNode node;

  @Before
  public void setUp() throws Exception {
    this.first = "hello world";
    this.next = null;
    this.node = new ListNode(this.first, this.next);
  }


  @Test
  public void getSize() throws Exception {
    assertEquals(1, this.node.getSize());
  }

  @Test
  public void getSizeZero() throws Exception {
    ListNode p = new ListNode(null, null);
    assertEquals(0, p.getSize());
  }

  @Test
  public void getSizeTwo() throws Exception {
    ListNode q = new ListNode("OOD", this.node);
    assertEquals(2, q.getSize());
  }


  @Test
  public void getFirst() throws Exception {
    assertEquals(this.first, this.node.getFirst());
  }

  @Test
  public void getNext() throws Exception {
    assertNull(this.node.getNext());
  }

}