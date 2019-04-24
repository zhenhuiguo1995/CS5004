package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PieceTest {
  private String firstName;
  private String lastName;
  private Name name;
  private int age;
  private Piece piece;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Alfred";
    this.lastName = "Stark";
    this.name = new Name(this.firstName, this.lastName);
    this.age = 20;
    this.piece = new Farmer(this.name, this.age);
  }

  @Test
  public void getName() throws Exception {
    assertSame(this.name, this.piece.getName());
  }

  @Test
  public void getAge() throws Exception {
    assertEquals(this.age, this.piece.getAge());
  }

  @Test(expected = IncorrectAgeRangeException.class)
  public void AgeNegative() throws IncorrectAgeRangeException {
    this.age = -1;
    this.piece = new Farmer(this.name, this.age);
  }

  @Test(expected = IncorrectAgeRangeException.class)
  public void AgeOverflow() throws IncorrectAgeRangeException {
    this.age = 129;
    this.piece = new Farmer(this.name, this.age);
  }
}