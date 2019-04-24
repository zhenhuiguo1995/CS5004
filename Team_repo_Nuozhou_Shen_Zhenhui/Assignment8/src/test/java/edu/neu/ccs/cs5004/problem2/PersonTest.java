package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private Name testName;
  private Name testName2;
  private LocalDate testDate;
  private LocalDate testDate2;
  private Person person1;
  private Person person2;
  private Person person3;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice","Green");
    testName2 = new Name("Bob","Clinton");
    testDate = LocalDate.of(1998,2,3);
    testDate2 = LocalDate.of(1980,7,23);
    person1 = new Person(testName,testDate);
    person2 = new Person(testName,testDate2);
    person3 = new Person(testName2,testDate);

  }

  @Test
  public void getName() {
    assertEquals(testName,person1.getName());
  }

  @Test
  public void getBirthday() {
    assertEquals(testDate,person1.getBirthday());
  }

  @Test
  public void testToString() {
    assertEquals("Person{name=Name{firstName='Alice', lastName='Green'}, birthday=1998-02-03}",person1.toString());
  }

  @Test
  public void equals() {
    assertTrue(person1.equals(person1));
    assertFalse(person1.equals(null));
    assertFalse(person1.equals("TEST"));
    assertFalse(person1.equals(person2));
    assertFalse(person1.equals(person3));
  }

  @Test
  public void testHashCode() {
    assertEquals(person1.hashCode(),person1.hashCode());
    assertNotEquals(person1.hashCode(),person2.hashCode());
  }
}