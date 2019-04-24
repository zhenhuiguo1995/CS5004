package edu.neu.ccs.cs5004;

import java.util.Comparator;

public class Actor extends Person {
  int actingYears;

  public Actor(int age, String name, int actingYears) {
    super(age, name);
    this.actingYears = actingYears;
  }
}
