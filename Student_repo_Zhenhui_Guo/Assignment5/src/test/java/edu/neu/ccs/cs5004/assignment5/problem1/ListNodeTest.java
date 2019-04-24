package edu.neu.ccs.cs5004.assignment5.problem1;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ListNodeTest {
  private String string;
  private Integer priority;
  private ListNode head;
  private Element node;
  private ListNode next;


  @Before
  public void setUp() throws Exception {
    this.string = "hello world";
    this.priority = 9;
    this.node = new Element(this.string, this.priority);
    this.next = null;
    this.head = new ListNode(this.node, this.next);
  }

  @Test
  public void add() throws Exception {
    Element element = new Element("OOD", -1);
    this.head.add(element);
    assertSame(this.node, this.head.getNode());
    assertSame(this.head.getNext().getNode(), element);
  }

  @Test
  public void addNull() throws Exception {
    this.head = new ListNode(null, null);
    Element element = new Element("OOD", -1);
    this.head = this.head.add(element);
    assertSame(element, this.head.getNode());
  }

  @Test
  public void addNotNull() throws Exception {
    Element element = new Element("OOD", 12);
    this.head = this.head.add(element);
    assertSame(element, this.head.getNode());
    assertSame(this.node, this.head.getNext().getNode());
  }



  @Test
  public void peek() throws Exception {
    assertSame(this.string, this.head.peek());
  }

  @Test(expected = IndexOutOfRangeException.class)
  public void peekNotExist() throws Exception {
    ListNode p = new ListNode(null, null);
    p.peek();
  }



  @Test
  public void removeFront() throws Exception {
    assertNull(this.head.removeFront());
  }

  @Test(expected = IndexOutOfRangeException.class)
  public void removeFrontNotExist() throws Exception {
    ListNode p = new ListNode(null, null);
    p.removeFront();
  }


  @Test
  public void isEmpty() throws Exception {
    assertFalse(this.head.isEmpty());
  }

  @Test
  public void Empty() throws Exception {
    assertTrue(new ListNode(null, null).isEmpty());
  }

  @Test
  public void getNode() throws Exception {
    assertSame(this.node, this.head.getNode());
  }

  @Test
  public void getNext() throws Exception {
    assertNull(this.head.getNext());
  }

  @Test
  public void equals() throws Exception {
    assertEquals(this.head, new ListNode(new Element("hello world", 9), null));
  }

  @Test
  public void getSizeOne() {
    assertSame(1, this.head.getSize());
  }

  @Test
  public void getSizeZero() {
    assertSame(0, new ListNode(null, null).getSize());
  }

  @Test
  public void getSizeTwo() {
    ListNode p = new ListNode(new Element("abs", 12), this.head);
    assertSame(2, p.getSize());
  }

  @Test
  public void equalsItself() {
    assertTrue(this.head.equals(this.head));
  }

  @Test
  public void notEqualsNUll() {
    assertFalse(this.head.equals(null));
  }

  @Test
  public void notEqualsOtherClass() {
    assertFalse(this.head.equals(new EmptyPriorityQueue()));
  }

  @Test
  public void notEqualsNode() {
    ListNode other = new ListNode(new Element("ood", 9), null);
    assertFalse(this.head.equals(other));
  }

  @Test
  public void notEqualsOther() {
    ListNode other = new ListNode(new Element("ood", 9), this.head);
    assertFalse(this.head.equals(other));
  }

}