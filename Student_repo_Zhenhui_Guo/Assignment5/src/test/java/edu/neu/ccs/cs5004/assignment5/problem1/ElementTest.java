package edu.neu.ccs.cs5004.assignment5.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ElementTest {
  private String string;
  private Integer priority;
  private Element element;

  @Before
  public void setUp() throws Exception {
    this.string = "a";
    this.priority = 3;
    this.element = new Element(this.string, this.priority);
  }

  @Test
  public void getString() throws Exception {
    assertSame(this.string, this.element.getString());
  }

  @Test
  public void getPriority() throws Exception {
    assertSame(this.priority, this.element.getPriority());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.element.equals(this.element));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.element.equals(null));
  }

  @Test
  public void notEqualsOtherClass() throws Exception {
    assertFalse(this.element.equals(new ArrayList<String>()));
  }

  @Test
  public void notEqualsString() throws Exception {
    assertFalse(this.element.equals(new Element("b", this.priority)));
  }

  @Test
  public void notEqualsPriority() throws Exception {
    assertFalse(this.element.equals(new Element(this.string, 4)));
  }

  @Test
  public void equalNew() throws Exception {
    assertTrue(this.element.equals(new Element(this.string, this.priority)));
  }

  @Test
  public void notEqualNull() throws Exception {
    assertFalse(this.element.equals(new Element(null, this.priority)));
  }

  @Test
  public void notEqualFirstNull() throws Exception {
    assertFalse((new Element(null, this.priority)).equals(this.element));
  }

  @Test
  public void notEqualNullPriority() throws Exception {
    assertFalse(this.element.equals(new Element(this.string, null)));
  }

  @Test
  public void notEqualNullFirstPriority() throws Exception {
    assertFalse((new Element(this.string, null)).equals(this.element));
  }

}