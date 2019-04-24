package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class InsuranceTest {

  private Person owner;
  private Person owner2;
  private List<Person> coverList;
  private List<Person> coverList2;
  private Person person1;
  private Person person2;
  private Name testName;
  private Name testName2;
  private LocalDate testDate;
  private LocalDate testDate2;
  private Insurance insurance;
  private Insurance insurance2;
  private Insurance insurance3;
  private Insurance insurance4;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice", "Green");
    testName2 = new Name("Bob", "Clinton");
    testDate = LocalDate.of(1998, 2, 3);
    testDate2 = LocalDate.of(1980, 7, 23);
    person1 = new Person(testName, testDate);
    person2 = new Person(testName, testDate2);
    owner = new Person(testName, testDate2);
    owner2 = new Person(testName2, testDate);
    coverList = new ArrayList<>();
    coverList2 = new ArrayList<>();
    coverList.add(person1);
    coverList2.add(person2);
    insurance = new Insurance(owner, coverList, testDate);
    insurance2 = new Insurance(owner2, coverList, testDate);
    insurance3 = new Insurance(owner, coverList2, testDate);
    insurance4 = new Insurance(owner, coverList, testDate2);


  }

  @Test
  public void getOwner() {
    assertEquals(owner, insurance.getOwner());
  }

  @Test
  public void getCoverList() {
    assertEquals(coverList, insurance.getCoverList());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(testDate, insurance.getExpirationDate());
  }

  @Test
  public void testToString() {
    assertEquals(
        "Insurance{owner=Person{name=Name{firstName='Alice', lastName='Green'}, birthday=1980-07-23}, coverList=[Person{name=Name{firstName='Alice', lastName='Green'}, birthday=1998-02-03}], expirationDate=1998-02-03}",
        insurance.toString());
  }

  @Test
  public void equals() {
    assertTrue(insurance.equals(insurance));
    assertFalse(insurance.equals(null));
    assertFalse(insurance.equals("TEST"));
    assertFalse(insurance.equals(insurance2));
    assertFalse(insurance.equals(insurance3));
    assertFalse(insurance.equals(insurance4));
  }

  @Test
  public void testHashCode() {
    assertEquals(insurance.hashCode(), insurance.hashCode());
    assertNotEquals(insurance.hashCode(), insurance2.hashCode());
  }
}